package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.callor.gallery.models.GalleryVO;

public interface GalleryService {

	List<GalleryVO> selectAll();



	GalleryVO createGallery(GalleryVO galleryVO, MultipartFile image_file) throws Exception;

}
