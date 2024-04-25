package com.callor.gallery.service;

import com.callor.gallery.models.GalleryVO;
/*
 * Spring MVC ���� Service �������̽� �� Ŭ����
 * MVC ���Ͽ����� Controller == Dao ���� ������ ���Ͽ�
 * �⺻���� CRUD �� ������ �� �ִ�.
 * �׷��� ���ؼ��� Controller �� Dao �� DI �Ͽ� ����� �ϸ�ȴ�
 * ������ Controller �� Front �� �����Ǿ� �ſ� ����ϰ� ȣ��Ǵ� Ŭ�����̴�
 * Controller Ŭ������ ���� ��ҵ��� ÷���Ǿ� ������ �ƹ����� ���ɻ�
 * �̽��� �߻��� �� �ִ�
 * 
 * �׷��� �ܺ� �ٸ� ���, ������ ����Ͽ� ������ ������ �ʿ��� ���
 * �߰��� Service �� �ΰ�, �װ����� ó���ϴ� ���� �ټҰ��� ������ ������ �ִ�.
 * 
 * ���� �ſ� �ܼ��ϰ� Controller �� Dao ���� 1:1 �� ��Ī�Ǿ� ������ �ɼ� �ִ� ����
 * ������ �߰��� Service �� Toss ������ �����ϵ��� �ϴ� ���� �ǰ��Ѵ�.
 */

public interface GalleryService {
	
	public GalleryVO createGallery(GalleryVO vo);

}
