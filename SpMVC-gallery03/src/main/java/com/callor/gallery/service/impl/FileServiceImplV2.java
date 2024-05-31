package com.callor.gallery.service.impl;

import org.springframework.stereotype.Service;

import com.callor.gallery.config.QualifierConfig;

/*
 * 프로젝트에서 한개의 interface를 implement하여 다수의 클래스를 정의하는 경우가 있다
 * 이럴때 사용하는 곳에서 interface를 사용하여 객체를 선언하고
 * 생성자나, setter등을 통하여 객체(bean)을 주입받는다.
 * 이럴 때 핸개의 interface를 implements 한 객체가 2개 이상일 경우
 * Spring Di 는 어떤 클래스를 주입해야할지 알 수 없다
 * Spring Di 에게 어떤 클래스(객체)를 주입해야할지 알려주기 위하여
 * Service Annotation 에 이름을 부여하고, 주입받는 곳에서는 Qualifier을 사용하여 
 * 명시적으로 어떤 클래스(객체) 를 주입받을지 선언해줘야 한다
 */
@Service(QualifierConfig.SERVICE.FILE_SERVICE_V2)
public class FileServiceImplV2 extends FileServiceImplV1{

	/*
	 * V1에서 생성자를 통하여 upLoadPath 변수를 주입받고 있다. 
	 * upload 변수는 V1과 V2에서 공통으로 사용해야 하는 변수
	 * 이럴 겨우 상속받은 클래스에서 반드시 생성자를 구현하고 생성자를 통하여 
	 * upLoadPath 변수를 주입받아야한다. 
	 */
	public FileServiceImplV2(String upLoadPath) {
		super(upLoadPath);
		// TODO Auto-generated constructor stub
	}

}
