package com.junhee.email.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// 보내는 사람(admin)의 Gmail아이디와 비밀번호
		return new PasswordAuthentication("aer38783@gmail.com", "choiparkkim123!");
	}

}
