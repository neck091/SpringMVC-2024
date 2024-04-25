package com.callor.gallery.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.GalleryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GalleryServiceImpl implements GalleryService{
	
	private final GalleryDao galleryDao;
	
	public GalleryServiceImpl(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
	}
	
	
	/*
	 * �Է�ȭ�鿡�� ����, ����, �̹���(base64)�� ���޹ް�
	 * ���⿡ �ۼ�����, �ۼ��ð�, PK ������ �����Ͽ� VO �� �ٽ� �����ϰ�
	 * Dao �� �����Ͽ� �����͸� insert �ϵ��� �ϱ�
	 */
	



	@Override
	public GalleryVO createGallery(GalleryVO vo) {
		
		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("YYY-MM-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		/*
		 * UUID v5(�Ǵ� v4) �� ����ϱ� ���Ͽ� randomUUID() method �� ȣ���Ͽ�
		 * UUID ���� �����
		 */
		vo.setG_id(UUID.randomUUID().toString());
		vo.setG_date(lt.format(date));
		vo.setG_time(lt.format(time));
		vo.setG_author("loo919239@gmail.com");
		
		log.debug("ID {}, date {}, time {}, subject {}", vo.getG_id(), vo.getG_date(), vo.getG_time(), vo.getG_subject());
		
		int ret = galleryDao.insert(vo);
		if(ret > 0) {
			return vo;
		}
		
		return null;
	}
	

}
