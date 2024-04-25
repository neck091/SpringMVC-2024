# Spring MVC, Thymeleaf 를 이용한 화면 템플릿 구현
- Spring MVC(5) 에서 Thymeleaf 사용하기
- 전통적으로 SpringMVC 에서는 JSP 를 사용하여 화면을 구현했다. 최근 10여냔 전부터 JSP 이외에 여러가지 화면 구현 도구들이 많이 생겨났다.
- Sprign 프로젝트에서 화면을 구현하는 도구를 `화면 템블릿`이라고 한다.
- 그중에서 `SprignMVC` 이후에 `Spring Boot` 가 나타나면서 매우 많이 사용하는 화면 템플릿이 있는데 바로 `Thymeleaf` 이다.
- `HTML` 방식의 정적 화면을 구현하고, 거기에 여러 도구를 첨가하는 방식으로 화면이 구현된다.
- 똑같은 화면 구현 파일을 화면디자이너와 개발자가 공유하는데 탁월한 역할을 수행한다.
- 개발자와 디자이너가 충돌하지 않고 협업할 수 있는 매우 좋은 도구이다.

# 설정
- dependency 설정
- `thymeleaf-springX` : 사용하는 `Spring FrameWork` 버전에 따라 적정한 도구를 설정
- `thymeleaf-layout-xxx` : thymeleaf 에서 Layout 설정을 쉽게 구현할수 있도록 도와주는 `3rd LIB` 이다.
- `layout` 도구는 `nz.net.ultraq.*` 에서 배포하는 도구를 주로 많이 사용한다.
```xml
<dependency>
	<groupId>org.thymeleaf</groupId>
	<artifactId>thymeleaf-spring5</artifactId>
	<version>3.1.2.RELEASE</version>
</dependency>

<dependency>
	<groupId>nz.net.ultraq.thymeleaf</groupId>
	<artifactId>thymeleaf-layout-dialect</artifactId>
	<version>3.3.0</version>
</dependency>
</dependencies>
```

# Spring 파일 업로드 프로젝트
- gallery-01 에서는 이미지를 base64 로 변환하여 DB table 에 저장했다.
- 이러한 방식은 오래전에 파일의 크기가 크지 않을때는 괜찮은 방법이었다.
- 요즘은 카메라 성능 등이 월등히 좋아져 이미지 크기가 매우 큰 경우가 많다.
- 일반적으로 2M 이하의 이미지는 Table 에 저장해도 큰 무리가 가지 않지만 그 이상되는 이미지를 Table 에 저장하면 전체 DBMS 시스템 자체의 성능이 매우 불안정하고 느려지게 된다.
- 이미지 파일은 파일 자체를 서버에 업로드하여 서버의 폴더에 저장하고, DB table 에는 파일에 대한 정보(파일이름)만 저장하는 형태로 구현한다.
- 이미지 파일(또는 기타 파일)을 업로드하는 여러가지 도구를 활용해야 한다.

## 도구 설치
- fileUpload 를 위한 dependency 설정
``` xml
```