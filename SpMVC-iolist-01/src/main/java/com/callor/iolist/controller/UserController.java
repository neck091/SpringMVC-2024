package com.callor.iolist.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.iolist.models.UserVO;
import com.callor.iolist.service.UserService;
import com.callor.iolist.utils.NamesValue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model ,String error) {
		
		model.addAttribute("ERROR",error);
		model.addAttribute("BODY", "USER_LOGIN");
		return "layout";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, HttpSession httpSession) {

		log.debug("USERNAME {}, PASSWORD {}", username, password);

		UserVO userVO = userService.login(username, password);
		if (userVO != null) {
			httpSession.setAttribute(NamesValue.SESSION.USER, userVO);

		} else {
			httpSession.removeAttribute(NamesValue.SESSION.USER);
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {

		// 로그인에 사용된 USER 속성을 삭제
		httpSession.removeAttribute(NamesValue.SESSION.USER);
		//모든 세션 정보를 삭제
//		httpSession.invalidate();
		return "redirect:/";

	}

}
