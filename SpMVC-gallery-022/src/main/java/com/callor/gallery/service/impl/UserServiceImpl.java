package com.callor.gallery.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.gallery.dao.RoleDao;
import com.callor.gallery.dao.UserDao;
import com.callor.gallery.models.RoleVO;
import com.callor.gallery.models.UserVO;
import com.callor.gallery.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;
	private final RoleDao roleDao;
	private final PasswordEncoder passwordEncoder;
	

	public UserServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
		super();
		this.userDao = userDao;
		this.roleDao = roleDao;
		this.passwordEncoder = passwordEncoder;
	}


	/*
	 * controller에서 회원가입을 요청한 사용자 정보를 받아서
	 * UserDao.insert()통하여 회원가입 하기
	 * 회원가입을 할 때 사용자의 권한을 어떻게 부여할 것인가
	 * 
	 * 전체 회원정보  table을 조회하여
	 * 최초의 회원가입이라면 ADMIN과 USER 권한을 부여하고
	 * 두번째 이후의 회원가입이라면 
	 * USER 권한만 부여하는 시스템으로 작동 
	 * 
	 * 주의
	 * @Transactional을 사용할 때 sql을 실행할 때 발생하는
	 * exception을 try.catch로 절대 처리해선 안됨
	 * 만약 sql명령을 실행하는 과정에서 exception이 발생하고
	 * 이를 method에서 자체적으로 try.catch로 처리를 해버리면
	 * 현재 mehod는 정상적으로 수행이 된 것으로 인식되어버림.
	 * 따라서 transaction처리가 무력화.
	 * 
	 *  그래서 @transactional 을 사용하고자 할 때는
	 *  반드시 method에서 throws를 통하여 호출한 곳으로 exception을 보내주어야 한다.
	 *  그래야만 중간에 transactional이 이를 감지하고 처리하게 됨
	 */
	
	@Transactional
	@Override
	public int create_user(UserVO userVO) throws DataAccessException {
		
		List<UserVO> resultVO = userDao.selectAll();
		List<RoleVO> grantList = new ArrayList<>();
		if(resultVO == null || resultVO.size() <1) {
			grantList.add(
					RoleVO.builder().
					r_username(userVO.getUsername())
					.r_role("ROLE_ADMIN").build());
			grantList.add(
					RoleVO.builder().
					r_username(userVO.getUsername())
					.r_role("ROLE_USER").build());
		}
		
		/*
		 * 입력 비번 암호화 후 vo에 세팅
		 */
		String encPassword = passwordEncoder.encode(userVO.getPassword());
		userVO.setPassword(encPassword);
		
		userDao.insert(userVO);
		roleDao.inserts(grantList, userVO.getUsername());
		return 0;
	}

	
	@Autowired
	@Override
	public void create_table() {
		try {
				userDao.create_table(null);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	try {
		roleDao.create_table(null);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	

}
