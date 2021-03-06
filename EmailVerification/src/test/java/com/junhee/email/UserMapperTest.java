package com.junhee.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junhee.email.model.UserVO;
import com.junhee.email.user.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserMapperTest {

	@Autowired
	private IUserMapper mapper;
	
	@Test
	public void RegisterTest() {
		
		UserVO user = new UserVO();
		user.setUserId("bbb1234");
		user.setUserPw("bbb1234!");
		user.setUserEmail("bbb1234@naver.com");
		user.setUserEmailHash("cccc");
		mapper.Register(user);
	}
	
	@Test
	public void CheckIdTest() {
		
		UserVO user = mapper.CheckId("abc1234");
		if(user == null) {
			System.out.println("중복되는 아이디 없음.");
		}else {
			System.out.println("중복되는 아이디입니다.");
		}
	}
	
	@Test
	public void CheckEmailTest() {
		UserVO user = mapper.CheckEmail("abc1234@naver.com");
		if(user == null) {
			System.out.println("중복되는 이메일 없음.");
		}else {
			System.out.println("중복되는 이메일입니다.");
		}
	}
	
	@Test
	public void GetEmailChecked() {
		
		UserVO user = mapper.CheckId("bbb1234");
		System.out.println(user);
		if(user == null) {
			System.out.println("존재하지 않는 유저");
		} else {
			if(user.isUserEmailChecked()) {
				System.out.println("이메일 인증됨");
			} else {
				System.out.println("이메일 인증 안 됨");
			}
		}
	}
	
	@Test
	public void SetEmailCheckTrueTest() {
		mapper.SetEmailChecked("bbb1234");
		System.out.println(mapper.CheckId("bbb1234"));
	}
	
}
