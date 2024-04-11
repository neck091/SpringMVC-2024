package com.callor.hello.service.auth;

import java.util.ArrayList;
import java.util.List;

//org.mysql.Authen... 사용하면 안됨.
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.hello.model.UserVO;

import lombok.extern.slf4j.Slf4j;

/*
 * 로그인을 시도하면 정상적인 로그인인지 확인 후
 * 사용자 정보와 권한정보가 포함된 객체를 생성하여 token을 발생
 * */
@Slf4j
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		String username=(String)authentication.getPrincipal();
//		String password =(String)authentication.getCredentials();

		String username = (String) authentication.getName();
		String password = (String) authentication.getCredentials().toString();

		log.debug("USERNAME : {}", "PASSWORD : {}", username, password);
		if (username == null || username.isBlank() || !username.equals("callor")) {
			/*
			 * 어떤 method가 중첩하여 호출이 될 때 내부에 깊이 포함된 method에서 바깥쪽의 method 에 메세지를 전달하고 싶을 때
			 * 강제로(일부러) exception을 발생하여 전달하는 방법
			 */
			throw new UsernameNotFoundException("USERNAME 없음");

		}

		if (password == null || password.isBlank() || !password.equals("12345")) {

			throw new BadCredentialsException("비밀번호 확인 필요");

		}

		List<GrantedAuthority> grantList = new ArrayList<>();
		grantList.add(new SimpleGrantedAuthority("ROLE_USER"));
		grantList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		grantList.add(new SimpleGrantedAuthority("ROLE_GUEST"));
		
		UserVO userVO = UserVO.builder().id(username).username("홍길동").email("callor@callor.com").build();
		//로그인한 사용자 정보와 권한 리스트를 묶어서 토큰 발행하기
		UsernamePasswordAuthenticationToken token =
				new UsernamePasswordAuthenticationToken(userVO, password,
				grantList);

		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
