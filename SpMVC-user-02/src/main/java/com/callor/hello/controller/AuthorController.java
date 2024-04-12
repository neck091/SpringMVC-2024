package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 403 오류가 발생할 경ㅇ우 /views/auth/denide/를 보여주긷
 */
@Controller
@RequestMapping(value="/auth")
public class AuthorController {
	
	@RequestMapping(value="/denide", method=RequestMethod.GET)
	public String denide() {
		return null;
	}

}
