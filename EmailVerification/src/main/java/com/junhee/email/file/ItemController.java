package com.junhee.email.file;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junhee.email.model.Item;
import com.junhee.email.model.ItemForm;
import com.junhee.email.model.UploadFile;

import jdk.internal.org.jline.utils.Log;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private FileService service;
	
	@GetMapping("newItem")
	public void ItemPage(@ModelAttribute ItemForm form) {
		
	}
	
	@PostMapping("/newItem")
	public String SaveItem(@ModelAttribute ItemForm form, RedirectAttributes ra) throws IllegalStateException, IOException {
		MultipartFile attachFile = form.getAttachFile();
		UploadFile uploadFile = service.StoreFile(attachFile);
		
		List<MultipartFile> imageFiles = form.getImageFiles();
		List<UploadFile> storeImageFiles = service.StoreFiles(imageFiles);
		
		// 데이터베이스에 저장
		Item item = new Item();
		item.setItemName(form.getItemName());
		item.setAttachFile(uploadFile);
		item.setImageFiles(storeImageFiles);
		service.Save(item);
		
		ra.addFlashAttribute("itemId",item.getId());
		
		return "redirect:/item/items/{itemId}";
	}
	
	@GetMapping("/item/items/{id}")
	public String items(@PathVariable Long id, Model model) {
		Item item = service.FindById(id);
		model.addAttribute("item", item);
		return "item/item-view";
		
	}
	
	@ResponseBody
	@GetMapping("/images/{filename}")
	public Resource DownloadImage(@PathVariable String filename) throws MalformedURLException {
		return new UrlResource("file: " + service.getFullPath(filename));
	}
	
	
	@GetMapping("/attach/{itemId}")
	public ResponseEntity<Resource> DownloadAttach(@PathVariable Long itemId) throws MalformedURLException{
		Item item = service.FindById(itemId);
		String storeFileName = item.getAttachFile().getStoreFileName();
		String uploadFileName = item.getAttachFile().getUploadFileName();
		
		UrlResource urlResource = new UrlResource("file: " + service.getFullPath(storeFileName));
		
		Log.info("uploadFileName: " + uploadFileName);
	}
	
}
