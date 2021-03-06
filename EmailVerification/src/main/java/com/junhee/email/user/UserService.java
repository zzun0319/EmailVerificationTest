package com.junhee.email.user;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junhee.email.model.UserVO;
import com.junhee.email.util.Gmail;
import com.junhee.email.util.SHA256;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;

	@Override
	public String Register(UserVO user) {
		
		UserVO returnUvo = mapper.CheckId(user.getUserId());
		if(returnUvo != null) {
			return "이미 사용중인 아이디입니다.";
		}
		
		returnUvo = mapper.CheckEmail(user.getUserEmail());
		if(returnUvo != null) {
			return "이미 사용중인 이메일입니다.";
		}
		else {
			user.setUserEmailHash(SHA256.getSHA256(user.getUserEmail()));
			mapper.Register(user);
			return "가입이 완료되었습니다.";
		}
	}

	@Override
	public String Login(UserVO user) {
		UserVO returnUvo = mapper.CheckId(user.getUserId());
		
		if(returnUvo == null) {
			return "존재하지 않는 계정입니다.";
		} else {
			if(!returnUvo.getUserPw().equals(user.getUserPw())) {
				return "비밀번호가 일치하지 않습니다.";
			}
			else {
				return "로그인 성공";
			}
		}
	}

	@Override
	public UserVO getOneInfo(String userId) {
		return mapper.CheckId(userId);
	}

	@Override
	public String AuthenticationMailSend(String userId) {

		UserVO user = mapper.CheckId(userId);
		
		String host = "http://localhost:8383/";
		String from = "aer38783@gmail.com"; /* 관리자의 이메일 계정 */
		String to = user.getUserEmail(); // 사용자의 이메일 계정
		String subject = "회원가입 인증 이메일입니다.";
		String content = "다음 링크에 접속하여 이메일 인증을 진행하세요." +
			"<a href='" + host + "user/emailCheckAction?code=" + new SHA256().getSHA256(to) + "'> 이메일 인증하기 </a>";
	
		Properties p = new Properties();
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.googlemail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		
		try{
			
			Authenticator auth = new Gmail();
			Session ses = Session.getInstance(p, auth);
			MimeMessage msg = new MimeMessage(ses);
			msg.setSubject(subject);
			Address formAddr = new InternetAddress(from);
			msg.setFrom(formAddr);
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/html;charset=UTF8");
			Transport.send(msg); // 실제 전송하는 부분
			
		} catch (Exception e){
			e.printStackTrace();
			return "인증 메일 전송 실패";
		}
		
		return "인증 메일 전송 성공";
	}

	@Override
	public String Authentication(String code, UserVO user) {

		if(code.equals(user.getUserEmailHash())) {
			mapper.SetEmailChecked(user.getUserId());
			return "이메일 인증에 성공했습니다.";
		}
		return "이메일 인증에 실패했습니다.";
	}
	
}
