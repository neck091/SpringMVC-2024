package com.callor.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;


import com.callor.iolist.model.IoVO;


public interface IoDao {
	@Select("SELECT * FROM tbl_iolist")
	public List<IoVO> selectAll();

	public int insert(IoVO vo);
	
	@Select("SELECT * FROM tbl_iolist"
			+ " WHERE seq = #{seq} ")
	public IoVO findByID(String seq);
	
	public int update(IoVO ioVO);
	
	@Delete("DELETE FROM tbl_iolist WHERE  seq = #{ioSeq}")
	public int delete(String ioSeq);
	
}
