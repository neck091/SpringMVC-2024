package com.callor.gallery.dao;

import java.util.List;

import com.callor.gallery.models.UserVO;

public interface UserDao {
	public List<UserVO> selectAll();
}
