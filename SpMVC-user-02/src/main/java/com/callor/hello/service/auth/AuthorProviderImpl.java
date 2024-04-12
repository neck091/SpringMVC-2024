package com.callor.hello.service.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authorProviderImpl")
public class AuthorProviderImpl implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String u_name = authentication.getName();
		String u_password = authentication.getCredentials().toString();
		
		if(u_name==null || u_name.isBlank()|| !u_name.equals("callor")) {
			throw new UsernameNotFoundException("USERNAME 입력바람");
		}
		
		
		if(u_password==null || u_password.isBlank()|| !u_password.equals("12345")) {
			throw new BadCredentialsException("비밀번호 틀렸음");
		}
		
		Map<String, String> user = new HashMap<>();
		user.put("username" , u_name );
		user.put("email" , "email@com" );
		
		List<GrantedAuthority> grantList = new ArrayList<>();
//		grantList.add(new SimpleGrantedAuthority("ADMIN"));
		grantList.add(new SimpleGrantedAuthority("USER"));
		
		UsernamePasswordAuthenticationToken token
		= new UsernamePasswordAuthenticationToken(user,u_password, grantList);
	
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	

}
