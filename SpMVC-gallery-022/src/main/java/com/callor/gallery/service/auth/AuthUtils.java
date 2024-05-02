package com.callor.gallery.service.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthUtils {
	/*
	 * 	PasswordEncoder encoder = new BCyptPasswordEncoder();
	 * 
	 * 비밀번호 등을 일방통행(단방향) 으로 암호화를 하기 위한 도구
	 * 이 클래스 type encoder 객체를 통해 회원가입을 할 때 
	 * 비밀번호를 암호화 하고 로그인을 할 때 다시 한 번 암호문과 비교하는 method 사용하게 됨
	 * 결국 encoder라는 객체를 두 번 생성, 사용.
	 * 그 때는 위와 같은 코드 사용
	 * 
	 * 하지만 Spring project는 다수의 client가 접근하는 server
	 * 프로젝트 전체에서 객체가 2번만 생성하면 되지만 사용자가 접근 할 경우
	 * 사용자마다 2번씩 생성되는 결과가 만들어짐.
	 * 이런 상황이 되면 Spring Project 원칙은 객체를 SingleTone으로 만들고
	 * 필요한 곳에 DI(의존성주입) 을 하여 사용하도록 하고 있음
	 * 
	 * 그래서 번거롭지만 Bean으로 생성해두는 코드를 미리 만든다.
	 * Bean 생성 코드는 보통*-context.xml에서 만들지만
	 * @Bean Annotation을 사용하여 Java code로 만들 수 있다.
	 * 
	 * 현재 authUtils클래스는 @Componet가 선언되어 있고
	 * Project가 실행 될 때 현재 package가 sacn 되고 @bean이 설정된 method가 
	 * 실행되면서 passwordEncoder 객체가 만들어지고  Spring Container 에 보관된다.
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
