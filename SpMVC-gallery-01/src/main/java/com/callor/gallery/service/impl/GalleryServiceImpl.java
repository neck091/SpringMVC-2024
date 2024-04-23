package com.callor.gallery.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.GalleryService;


@Service
public class GalleryServiceImpl  implements GalleryService{
	
	private final GalleryDao galleryDao;
	
	public GalleryServiceImpl(GalleryDao galleryDao) {
		super();
		this.galleryDao = galleryDao;
	}

	/*
	 * 입력 화면에서 제목, 내용, 이미지(base64)를 전달받고
	 * 여기에 작성일자, 작성시각, PK값을 생성하여 VO를 다시 세팅하고 
	 * Dao에 전달하여 데이터를ㄹ insert하도록 하기
	 */

	@Override
	public GalleryVO createGallery(GalleryVO vo) {
	LocalDateTime lt = LocalDateTime.now();
	DateTimeFormatter date = DateTimeFormatter.ofPattern("YYYY-MM-dd");
	DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	vo.setG_id(UUID.randomUUID().toString());
	vo.setG_date(lt.format(date));
	vo.setG_time(lt.format(time));
	vo.setG_author("email@email.com");
	int ret = galleryDao.insert(vo);
	if(ret>0) {
		return vo;
	}
	return null;
	

	}

}
