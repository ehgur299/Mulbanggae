package com.mul.product.dao;

import com.mul.product.model.CommonException;
import com.mul.product.model.UserType;

public interface UserTypeDao {
	
	public UserType select(Integer id) throws CommonException;

}
