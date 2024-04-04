package com.callor.iolist.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.iolist.persistance.IolistDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private final IolistDao iolistDao;
	public HomeController(IolistDao iolistDao) {
		this.iolistDao=iolistDao;
	}

	@Autowired
	public void create_table() {
		this.iolistDao.create_iolist_table(null);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		

		return "layout";
	}
	
}
