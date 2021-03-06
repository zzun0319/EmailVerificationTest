package com.junhee.email.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.junhee.email.model.Item;
import com.junhee.email.model.UploadFile;

@Service
public class FileService implements IFileService {

	@Autowired
	@Qualifier("uploadPath")
	String uploadPath;
	
	@Autowired
	private IFileMapper mapper;
	
	private Map<Long, Item> store = new HashMap<>();

	@Override
	public Item Save(Item item) {
		
		store.put(item.getId(), item);
		return item;
	}

	@Override
	public Item FindById(Long id) {
		return store.get(id);
	}

	@Override
	public String getFullPath(String fileName) {
		return uploadPath + fileName;
	}

	@Override
	public UploadFile StoreFile(MultipartFile multipartFile) throws IllegalStateException, IOException {
		if(multipartFile.isEmpty()) {
			return null;
		}
		
		String originalFileName = multipartFile.getOriginalFilename();
		String storeFileName = CreateStoreFileName(originalFileName);
		
		multipartFile.transferTo(new File(getFullPath(storeFileName)));
		
		return new UploadFile(originalFileName, storeFileName);
	}
	
	private String ExtractExtension(String originalFileName) { // 확장자 추출
		
		int pos = originalFileName.lastIndexOf(".");
		return originalFileName.substring(pos + 1);
	}
	
	private String CreateStoreFileName(String originalFileName) { // 서버에 저장하는 파일명 만들기
		
		String ext = ExtractExtension(originalFileName);
		String uuid = UUID.randomUUID().toString();
		return uuid + "." + ext;
		
	}

	@Override
	public List<UploadFile> StoreFiles(List<MultipartFile> multipartFiles) throws IllegalStateException, IOException {

		List<UploadFile> storeFileResult = new ArrayList<>();
		for(MultipartFile multipartFile : multipartFiles) {
			if(!multipartFile.isEmpty()) {
				storeFileResult.add(StoreFile(multipartFile));
			}
		}
		
		return storeFileResult;
	}
	
}
