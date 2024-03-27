package com.callor.hello.service.impl;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

public class UserServiceImpl implements UserService{
		
		public UserDto getUser() {
			
			UserDto user = new UserDto();
			user.setUsername("아이디");
			user.setPassword("비번");
			user.setName("이름");
			user.setEmail("이메일");
			user.setTel("전번");
			return user;
			
			
	
		// TODO Auto-generated constructor stub
	}

}
