package com.callor.gallery.dao;

import java.util.List;

import com.callor.gallery.models.BBsVO;

/*
 * Generic interface ����Ͽ� Dao interface �����
 * GenerucDao �� ����� 5���� CRUD method �� �״�� ����� �޴´�
 * 		�̶� Return type �� PK �Ű������� type �� �ʿ��� ��ҷ� ��ü�Ѵ�
 * 		��ü�Ҷ� Generic Type(<>)�� ����� �ش�
 * �� �ܿ� �ʿ��� method �� ������ ������ �����Ͽ� ����� �� �ִ�
 * 
 * 	�ᱹ BBsDao ���� �� 8������ method �� ����Ǵ� �Ͱ� ����
 */
public interface BBsDao extends GenericDao<BBsVO, String> {
	
	public List<BBsVO> findByDate(String sdate, String edate);
	public List<BBsVO> findBySubject(String subject);
	public List<BBsVO> findContent(String content);
	
//	public List<BBsVO> selectAll();
//	public BBsVO findById(String pk);
//	
//	public int insert(BBsVO vo);
//	public int update(BBsVO vo);
//	public int delete(String pk);

}
