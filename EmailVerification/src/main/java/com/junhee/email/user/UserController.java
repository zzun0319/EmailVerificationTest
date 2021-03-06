package com.junhee.email.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junhee.email.model.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/register")
	public void RegisterPage() {}
	
	@PostMapping("/register")
	public String Register(UserVO user, RedirectAttributes ra) {
		String msg = service.Register(user);
		ra.addFlashAttribute("msg", msg);
		if(msg.equals("가입이 완료되었습니다.")) {
			return "redirect:/user/login";
		}
		else {
			return "redirect:/user/register";
		}
	}
	
	@GetMapping("/login")
	public void LoginPage() {}
	
	@PostMapping("/login")
	public String Login(UserVO user, RedirectAttributes ra, HttpSession session) {
		String msg = service.Login(user);
		ra.addFlashAttribute("msg", msg);
		if(msg.equals("로그인 성공")) {
			session.setAttribute("user", service.getOneInfo(user.getUserId()));
			return "redirect:/user/mypage";
		}else {
			return "redirect:/user/login";
		}
	}
	
	@GetMapping("/mypage")
	public void MyPage() {}
	
	@GetMapping("/authentication")
	public String AuthenticationPage(String userId, RedirectAttributes ra) {
		String msg = service.AuthenticationMailSend(userId);
		ra.addFlashAttribute("msg", msg);
		if(msg.equals("인증 메일 전송 성공")) {
			return "user/authentication";
		}
		else {
			return "redirect:/user/mypage";
		}
	}
	
	@GetMapping("/emailCheckAction")
	public String AuthenticationProcess(String code, HttpSession session, RedirectAttributes ra) {
		UserVO user = (UserVO) session.getAttribute("user");
		String msg = null;
		if(user == null) {
			msg = "로그인이 필요합니다.";
			ra.addFlashAttribute("msg", msg);
			return "redirect:/user/login";
		}
		
		msg = service.Authentication(code, user);
		session.setAttribute("user", service.getOneInfo(user.getUserId()));
		ra.addFlashAttribute("msg", msg);
		return "redirect:/user/mypage";
	}
	
}
