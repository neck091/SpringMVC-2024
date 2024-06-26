package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;
import com.callor.hello.service.impl.UserServiceImpl;

/**
 * Spring routing Spring 에서는 Routing을 Controller라고 한다. Spring class에 @Controller
 * 를 부착하면 이 클래스가 Routing 을 수행하게 된다. Class의 method 들이 각각의 Routing 이 되어 응답을 처리한다.
 * 
 * 이 때 각 method에는 @RequestMapping 과 RequestMethod를 부착하여 각각의 Routing 경로와 응답
 * method 를 지정한다
 * 
 * @RequestMappping을 Controller 에 부착하면 대표 Routing 이 되고, 각 method의 RequestMapping
 *                   과 함께 융합된 응답 Mapping이 되고 Routing을 수행한다
 * 
 *                   이 클래스는 http://localhost:8080/hello/user/login 과 같은 요청을 처리하는
 *                   routing이 된다.
 * 
 *
 */
@Controller
@RequestMapping(value = "/user")

public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		//생성
		
//		userService = new UserServiceImpl();
		
		//사용
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, Model model) {
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		return null;

	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {

//		UserService userService = new UserServiceImpl();
		UserDto user = userService.getUser();
		model.addAttribute("USER", user);
		return null;
	}

//	@RequestMapping(value = "/join", method = RequestMethod.POST)
//	public String join(String username, String password, String name, String email, String tel) {
//		return null;
//	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserDto userDto, Model model) {
		model.addAttribute("USER", userDto);
		return null;
	}

}
