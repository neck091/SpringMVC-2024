package com.callor.gallery.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(basePackages = {"com.callor.gallery.dao"})
public class MyBatisContextConfig {


	private final ApplicationContext context;
	
	public MyBatisContextConfig(ApplicationContext context) {
		super();
		this.context = context;
	}

	@Bean
	public DataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/galleryDB2");
		ds.setUsername("root");
		ds.setPassword("!Biz8080");
		return ds;
	}

	@Bean
	public SqlSessionFactoryBean sessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();




		bean.setDataSource(this.ds());
		bean.setTypeAliasesPackage("com.callor.gallery.models");
		//src/main/resurce 폴더에 mapper/*-mapper/.xml을 찾아라
		Resource resource= context.getResource("classpath:/**/mapper/*-mapper.xml");
		bean.setMapperLocations(resource);
		return bean;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		PlatformTransactionManager manager = new DataSourceTransactionManager();

		
		/*
		 * manager 객체는 Platfor...manager 인터페이스를 사용하여 선언
		 * 이 인터페이스는 다양한 transaction을 실행하기 위한 설계도
		 * datasource...manager은 platfor..manager 인터페이스를 사용하여
		 * 구현된 구현체 클래스이다.
		 * 
		 * datasource... manager platfor 인터페이스를 implement 하였지만
		 * 자체적으로 코드를 구현하면서 여러가지 method를 별도로 가지고있다.
		 * 우리는 datasoruce...manager 에게 datasource(ds)를 알려주고
		 * datasoruce 차원에서 tarnsaction을 수행하도록 하려고 한다.
		 * 
		 * 그런데 Platfor..에는 datasource를 주입하는 method가 정의되지 않음.
		 * 결국 platfor...에는 없지만 datasource...manager에만 있는
		 * setdatasource method를 사용해야한다
		 * 이럴 때 paltfor 에는 없지만 datasour..manager에만 있는 method를 사용하기 위해선
		 * dataSource...Manager type 으로 Castion(강제형변환)을 수행해야 함.
		 */
		
		
		((DataSourceTransactionManager)manager).setDataSource(this.ds());
		return manager;
	}
}
