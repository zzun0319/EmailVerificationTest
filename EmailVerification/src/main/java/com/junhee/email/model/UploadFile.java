package com.junhee.email.model;

public class UploadFile {

	private String uploadFileName;
	private String storeFileName;
	
	public UploadFile() {
		// TODO Auto-generated constructor stub
	}

	public UploadFile(String uploadFileName, String storeFileName) {
		this.uploadFileName = uploadFileName;
		this.storeFileName = storeFileName;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getStoreFileName() {
		return storeFileName;
	}

	public void setStoreFileName(String storeFileName) {
		this.storeFileName = storeFileName;
	}

	@Override
	public String toString() {
		return "UploadFile [uploadFileName=" + uploadFileName + ", storeFileName=" + storeFileName + "]";
	}
	
}
