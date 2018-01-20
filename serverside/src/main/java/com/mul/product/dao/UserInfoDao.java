package com.mul.product.dao;

import java.util.List;

import com.mul.product.model.CommonException;
import com.mul.product.model.UserInfo;

public interface UserInfoDao {

	public List<UserInfo> selectAll() throws CommonException;
	
	public UserInfo select(Integer uid) throws CommonException;
	
	public void insert(UserInfo user) throws CommonException;
	
	public void insertUserTypes(UserInfo user) throws CommonException;
	
	public void delete(Integer uid) throws CommonException;
	
	public void deleteUserTypes(Integer uid) throws CommonException;
	
	public void update(UserInfo user) throws CommonException;
	
	public UserInfo SelectById(String id) throws CommonException;
	
}
