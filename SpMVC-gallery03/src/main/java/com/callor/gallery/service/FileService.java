package com.callor.gallery.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	
	//싱글
	public String fileUp(MultipartFile file) throws IOException;
	//멀티
	public List<String> filesUp(MultipartHttpServletRequest files);

}






