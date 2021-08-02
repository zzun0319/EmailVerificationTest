package com.junhee.email.file;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	@Qualifier("uploadPath")
	String uploadPath;

	@Autowired
	private FileService service;
	
	@GetMapping("/upload")
	public void UploadPage() {
		System.out.println("파일 업로드 페이지로 이동");
	}
	/*
	 * @PostMapping("/upload") public String SaveFile(HttpServletRequest request)
	 * throws IOException, ServletException {
	 * 
	 * String itemName = request.getParameter("itemName");
	 * System.out.println(request);
	 * 
	 * Collection<Part> parts = request.getParts(); System.out.println(parts);
	 * 
	 * return "file/upload"; }
	 */
	
	@PostMapping("/upload")
	public String SaveFile(@RequestParam String itemName, @RequestParam MultipartFile file, 
			HttpServletRequest request) throws IllegalStateException, IOException {
		
		System.out.println("request: " + request);
		System.out.println("itemName: " + itemName);
		System.out.println("multipartFile: " + file);
		
		if(!file.isEmpty()) {
			String fullPath = uploadPath + file.getOriginalFilename();
			System.out.println("파일저장 fullPath: " + fullPath);
			file.transferTo(new File(fullPath));
		}
		return "file/upload";
	}
		
		
	
	
}
