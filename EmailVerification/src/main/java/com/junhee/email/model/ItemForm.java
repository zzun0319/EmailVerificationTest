package com.junhee.email.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ItemForm {

	private Long itemId;
	private String itemName;
	private MultipartFile attachFile;
	private List<MultipartFile> imageFiles;
	
	public ItemForm() {
		// TODO Auto-generated constructor stub
	}

	public ItemForm(Long itemId, String itemName, MultipartFile attachFile, List<MultipartFile> imageFiles) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.attachFile = attachFile;
		this.imageFiles = imageFiles;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public MultipartFile getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(MultipartFile attachFile) {
		this.attachFile = attachFile;
	}

	public List<MultipartFile> getImageFiles() {
		return imageFiles;
	}

	public void setImageFiles(List<MultipartFile> imageFiles) {
		this.imageFiles = imageFiles;
	}

	@Override
	public String toString() {
		return "ItemForm [itemId=" + itemId + ", itemName=" + itemName + ", attachFile=" + attachFile + ", imageFiles="
				+ imageFiles + "]";
	}
	
	
	
}
