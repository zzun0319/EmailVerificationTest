package com.junhee.email.user;

import com.junhee.email.model.UserVO;

public interface IUserService {

	public String Register(UserVO user);
	
	public String Login(UserVO user);
	
	public UserVO getOneInfo(String userId);
	
	public String AuthenticationMailSend(String userId);
	
	public String Authentication(String code, UserVO user);
}
