package com.callor.gallery.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.GalleryService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
	private final GalleryDao galleryDao;
	private final GalleryService galleryService;
	
	

	public HomeController(GalleryDao galleryDao, GalleryService galleryService) {
		super();
		this.galleryDao = galleryDao;
		this.galleryService = galleryService;
		this.galleryDao.create_table();
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
	
		
		return "home";
	}
	
	@RequestMapping(value="/insert" , method=RequestMethod.GET)
	public String insert() {
		return "input";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(MultipartHttpServletRequest files, GalleryVO galleryVO) {
	log.debug("GALLERY {}",galleryVO.toString());
	
	//MultipartHttpServletRequest로부터 파일리스트 추출
	/*
	 * getFiles() method를 사용하는데 이때 매개변수로
	 * form.input[type="file"] 의 name 속성 문자열 사용
	 */

	List<MultipartFile> fileList= files.getFiles("files");
	log.debug("IMG {}", fileList.get(0).getOriginalFilename());
		return "redirect:/";
	}
}
