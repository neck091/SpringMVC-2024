package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.OrderVO;


/**
 * 
 * DBMS 연동
 * 구현이 필요한 5가지 method 구조
 *
 */
public interface OrderDao {
	// table 의 모든 데이터들을 select 하기
	//이 함수의 return type이 무엇일까
	
	@Select("SELECT * FROM tbl_orders")
	public List<OrderVO> selectAll();
	
}