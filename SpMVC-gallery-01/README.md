# Spring 이미지 갤러리 프로젝트
- MySQL, Mybatis, Tiles 를 이용한 갤러리 프로젝트 

## Tiles를 이용한 Layout 설정 
- dpendency 설정
```xml
	<properties>
		<org.apache.tiles-version>3.0.8</org.apache.tiles-version>
	</properties>

	<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-core -->
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-core</artifactId>
			<version>3.0.8</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-extras -->
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-extras</artifactId>
			<version>3.0.8</version>
		</dependency>

```

## `tiles-context.xml` `ViewResolver` 설정
```xml
<bean
		class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
		<list>
		<value>/WEB-INF/spring/appServlet/tiles-layout/*-layout.xml</value>
		</list>

		</property>
	</bean>
	<bean
		class="org.springframework.web.servlet.view.UrlBasedViewResolver">
		<property name="viewClass"
			value="org.springframework.web.servlet.view.tiles3.TilesView" />
		<property name="order" value="1" />
	</bean>
```

- `layout.xml` 위치 설정
- `order` 값을 반드시 1로 설정
## `*-layout.xml`에 `ViewResolver`를 받아서 `Rendering`하는 법
- `default` definition 설정
- 전체 layout 을 감쌀 box-layout
- 여기에는 모든 페이지에 공통으로 include 할 파일을 설정해 둔다.

- `controller` 에서 `return` 된 문자열을 받아서 처리하는 부분
- `return home` 이 실행되면 다음의 definition 이 응답을 받아서 rendering 할 준비
- `default` 로 설저오딘 definition을 layout으로 삼아 화면을 구성한다

```xml
<tiles-definitions>
	<definition name="default"
		template="/WEB-INF/views/home.jsp">
		<put-attribute name="head" value="/WEB-INF/views/includes/include-head.jsp" />
		<put-attribute name="header" value="/WEB-INF/views/includes/include-header.jsp" />
		<put-attribute name="nav" value="/WEB-INF/views/includes/include-main.jsp" />
	</definition>

```
