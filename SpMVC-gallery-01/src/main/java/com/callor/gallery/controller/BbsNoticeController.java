package com.callor.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/bbs/notice")
public class BbsNoticeController {
	
	
	
	@RequestMapping(value={"/","" }, method=RequestMethod.GET )
	public String home() {
		return null;
	}
	
	@RequestMapping(value="/notice/write", method =RequestMethod.GET)
	public String write() {
		return null;
	}

	
}
