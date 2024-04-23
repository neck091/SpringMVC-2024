package com.callor.gallery.service;

import com.callor.gallery.models.GalleryVO;



/*
 * Spring MVC에서 Service 인터페이스 및 클래스 
 * MVC 패턴에서는 COntroller ==Dao 간 연결을 통해 기본적인  CRUD 구현 가능
 * 그러기 위해선 COntroller 에 Dao를 DI 하여 사용하면 됨
 * 하지만 COntroller는 Front와 연계되어 매우 빈번하게 호출되는 클래스이다
 * COntroller 클래스에 많은 요소들이 첨가되어 있으면 아무래도 성능상에 이슈 발생
 * 
 * 그래서 외부 다른 요소, 도구를 사용하여 연산을 수행이 필요한 경우 중간에 Service 를 두고 그곳에서 처리하는 것이 
 * 다소간 연산의 이점이 있음
 * 
 * 만약 매우 단순하게 controller와 dao 간에 1:1로 매칭되어 진행이 될 수 있는 경우라면
 * 가급적 중간에 service가 toss역할을 수행하도록 하는 것을 권장.
 */
public interface GalleryService {

	
	
	public GalleryVO createGallery(GalleryVO vo);
	
	
}
