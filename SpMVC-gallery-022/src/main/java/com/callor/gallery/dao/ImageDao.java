package com.callor.gallery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.gallery.models.ImageVO;

public interface ImageDao  extends GenericDao<ImageVO, String>{


	
	/*
	 * dao 의 method에서 mapper 로 전달하는 매개변수가 1개만 있을 경우는 이름이 중요하지 않음
	 * 매개변수 이름이 pk라고 했을 때 mapper 에서는 #{id}처럼 사용해도 아무런 문제가 없다.
	 * 
	 * 그런데 dao에서 mapper로 전달하는 매개변수가 2개 이상일 경우 이름이 매우 중요함
	 * 때문에 @Param()이라는  Annotaion을 사용하여 각각의 매개변수에 이름을 지정,
	 * mapper에서는 그 이름을 사용해야함
	 */
	public int inserts(
			
			@Param("g_id")
			String i_gid, @Param("images") List<ImageVO> resultNames);
	
	

}
