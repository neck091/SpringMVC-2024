package com.callor.hello.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.hello.dao.RoleDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.RoleVO;
import com.callor.hello.models.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider {

	//
	// @Autowired
	/**
	 * 기본생성자를 통하여 UserDao type 의 userDao 객체를 주입받아라 라는 선언 Autowired를 사용하여 생성자 주입을 하게
	 * 되면 userDao 객체에 final을 사용할 수 없다. 클래스영역, 필드영역에 선언되는 객체 (클래스를 이용하여 선언한 변수들)는 가급적
	 * final을 부착시키는 것이 메모리 관리에서 좋다고 한다. final을 부착하면 사용이 종료된 객체들이 자동으로 GC(Garbage
	 * Collection, 객체 메모리 제거)가 된다. final 을 부착하지 않으면 GC가 지연되는 현상이 있다고 한다. 메모리가 낭비되는
	 * 현상(memory Leak)이 있을 수 있다.
	 * 
	 */
	private UserDao userDao;
	private final PasswordEncoder passwordEncoder;

	private final RoleDao roleDao;

	// 로그인 과정을 가로채서 custom 하는 곳
	public AuthProviderImpl(PasswordEncoder passwordEncoder, UserDao userDao,
			RoleDao roleDao) {
		super();
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
		this.roleDao = roleDao;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		log.debug("로그인한 사용자 정보 {}, {}", username, password);

		UserVO userVO = userDao.findById(username);
		if (userVO == null) {

			// 사용자 아이디가 db에서 조회가 안되면 exception을 강제발생시켜 코드의 진행 중단,
			// method 를 deep 호출한 곳까지 되돌리기 front 까지 메세지를 전달하기 위함.
			throw new UsernameNotFoundException(String.format("USERNAME 확인 : %s 는 없음", username));
		}

		boolean passOK = passwordEncoder.matches(password, userVO.getPassword());
		if (!passOK) {
			throw new BadCredentialsException("비밀번호 다시 확인");
		}



		List<RoleVO> roles = roleDao.findByUserName(username);
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

		for (RoleVO r : roles) {
			grantList.add(new SimpleGrantedAuthority(r.getR_role()));
		}

		Authentication token = new UsernamePasswordAuthenticationToken(userVO, password, grantList);

		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
