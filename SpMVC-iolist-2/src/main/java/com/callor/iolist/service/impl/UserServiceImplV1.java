package com.callor.iolist.service.impl;

import org.springframework.stereotype.Service;

import com.callor.iolist.models.UserVO;
import com.callor.iolist.service.UserService;
import com.callor.iolist.utils.NamesValue;

@Service(NamesValue.QUALIFIER.USER_SERVICE_V1)
public class UserServiceImplV1 implements UserService {
	
	/***
	 * 사용자 정보 받아서 확인해서 맞으면 리턴
	 */
	@Override
	public UserVO login(String username, String password) {
		
		if(username.equalsIgnoreCase("callor") && password.equals("12345")) {
			UserVO userVO = UserVO.builder()
					.username(username)
					.password(password)
					.tel("010-1111-1111")
					.name("이몽룡")
					.email("callor@callor.com")
					.build();
			return userVO;
		}
		return null;
	}
	

}
