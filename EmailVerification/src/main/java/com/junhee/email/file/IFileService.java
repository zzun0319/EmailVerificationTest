package com.junhee.email.file;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.junhee.email.model.Item;
import com.junhee.email.model.UploadFile;

public interface IFileService {

	public Item Save(Item item);
	
	public Item FindById(Long id);
	
	public String getFullPath(String fileName);
	
	public UploadFile StoreFile(MultipartFile multipartFile) throws IllegalStateException, IOException;

	public List<UploadFile> StoreFiles(List<MultipartFile> multipartFiles) throws IllegalStateException, IOException;
}
