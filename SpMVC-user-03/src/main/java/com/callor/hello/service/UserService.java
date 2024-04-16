package com.callor.hello.service;

import com.callor.hello.models.UserVO;

public interface UserService {

	//회원가입을 할 때 사용할 method
	//JAVA DDCS : **로 시작하는 주석
	/**
	 * 회원가입 method
	 * @param createUserVO
	 * @return UserVO
	 * @author callor
	 * @since 2024-04-15
	 */
	// 회원가입을 할때 사용할 method
	public UserVO createUser(UserVO createUserVO);


}
