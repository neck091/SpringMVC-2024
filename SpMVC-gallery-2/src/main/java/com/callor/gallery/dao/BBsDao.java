package com.callor.gallery.dao;

import java.util.List;

import com.callor.gallery.models.BBsVO;


/*
 * Generic interface 상속하여 Dao interface 만들기
 * GenericDao에 선언된 5가지  CRUD method는 그대로 상속받음
 * 이때 return type과 pk매개변수의 type을 필요한 요소로 대체
 * 대체할 때 Generic Type(<>)에 명시
 * 그외 필요한 명령어가 있으면 별도로 선언하여 사용 가능
 * bbs엔 총 8개의 method가 선언되는 것과 같음
 * */
public interface BBsDao extends GenericDao<BBsVO, String>{
	
	public List<BBsVO> findByDate(String sdate, String edate);
	public List<BBsVO> findBySubject(String subject);
	public List<BBsVO> findByContent(String content);
	
//	
//	public List<BBsVO> selectAll();
//	public BBsVO findById(String pk);
//	
//	public int insert(BBsVO vo);
//	public int update(BBsVO vo);
//	public int delete(String pk);
	
}
