package com.callor.hello;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*
		 * Router 의 method 가 문자열을 return 하면
		 * Web-INF / views 폴더에서 `문자열.jsp` 파일을 찾아서
		 * rendering 한 후 Response를 한다
		 * 
		 * 그런데 method 에서 null 을 return 하면
		 * 자신이 요청받은 Request Routing 주소를 문자열로 return 한 것과
		 * 똑같이 작동
		 * 
		 * 즉, return "user/login" 과 같다.
		 * */
		
		return "home";
	}
	
}
