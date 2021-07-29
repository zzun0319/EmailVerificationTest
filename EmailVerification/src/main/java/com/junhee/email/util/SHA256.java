package com.junhee.email.util;

import java.security.MessageDigest;

public class SHA256 {

	public static String getSHA256(String input) { // 이메일을 입력 받고 그 이메일에 해시값 적용
		StringBuffer result = new StringBuffer();
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] salt = "Hello! This is Salt.".getBytes(); // 악의적인 공격으로부터 어느정도 방어가 됨.
			digest.reset();
			digest.update(salt);
			byte[] chars = digest.digest(input.getBytes("UTF-8"));
			for(int i = 0; i < chars.length; i++) {
				String hex = Integer.toHexString(0xff & chars[i]);
				if(hex.length() == 1) result.append("0");
				result.append(hex);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result.toString();
	}
	
}
