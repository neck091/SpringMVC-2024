package com.callor.gallery.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.config.QualifierConfig;
import com.callor.gallery.models.ImageVO;
import com.callor.gallery.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.FILE_SERVICE_V1)
public class FileServiceImplV1 implements FileService {

	/*
	 * 편의상 FileServiceImplV1 을 FileServiceV2에서 상속하였다 V1과 V2는 FileServie 인터페이스를
	 * Implements 하고 있다 결국 두 클래스는 모두 FileService 인터페이스의 자손이다 V1에서 구현된 코드를 V2에서 확장 또는
	 * 일부변경 하여 사용하고자 한다. 이때 V1과 V2는 모두 upLoadPath변수를 사용해야한다. 이럴 경우 변수를 private로
	 * 선언해버리면 V2에서 다시 생성자를 통하여 upLoadPath 변수를 주입받아야함. 상속을 해주려는 클래스와 상속을 받는 클래스에서
	 * 공통으로 사용하는 변수가 있을 경우 이 변수는 protected로 선언해야한다.
	 * 
	 * 또한 유의해야 할 것은 생성자는 상속되지 않는다.
	 * 
	 */
	protected final String upLoadPath;

	public FileServiceImplV1(String upLoadPath) {
		super();
		this.upLoadPath = upLoadPath;
		log.debug("업로드폴더 {}", this.upLoadPath);
	}

	@Override
	public String fileUp(MultipartFile file) throws IOException {

		String fileName = file.getOriginalFilename();

		if (fileName.isBlank()) {
			return null;
		}
		File path = new File(upLoadPath);

		// 업로드할 폴더가 없으면 폴더 생성하기
		if (!path.exists()) {
			/*
			 * path.mkdir*() path.mkdirs() 폴더 생성 method mkdir : 한 개의 폴더만 생성 : app/upload를
			 * 생성할 경우 app폴더가 없으면 오류 발생 mkdirs : 여러 경로의 폴더 생성
			 */
			path.mkdirs();
		}

		String uuid = UUID.randomUUID().toString();
		// 원래의 파일 이름 앞에 uuid를 부착하여 업로드할 파일이름 생성
		// 파일이름 injection 공격 대비
		fileName = String.format("%s-%s", uuid, fileName);
		File upload = new File(upLoadPath, fileName);

		// multipart 클래스에 정의된 파일 전송 method
		file.transferTo(upload);

		// db에 파일 이름을 저장하기 위해 변경된 파일이름을 return
		return fileName;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) {
		
		/*
		 * view의 form input[type= 'file'] tag의 name 속성을 통하여 파일 리스트 추출하기
		 */
		List<MultipartFile> fileList = files.getFiles("files");
		List<ImageVO> resultFiles = new ArrayList<>();
		for(MultipartFile file : fileList) {
			String resultName = this.fileUp(file);
			String originName = file.getOriginalFilename();
			ImageVO vo = ImageVO.builder()
					.i_up_image(resultName).i_origin_image(originName).build();
					
					resultFiles.add(vo);
			
		}
		return resultFiles;
	
		
	}

}
