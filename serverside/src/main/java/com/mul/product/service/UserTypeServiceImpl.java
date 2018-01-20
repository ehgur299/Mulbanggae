package com.mul.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mul.product.dao.UserTypeDao;
import com.mul.product.model.UserType;

@Service
public class UserTypeServiceImpl implements UserTypeService {
	
	@Autowired
	private UserTypeDao dao;

	@Override
	public UserType findById(Integer id) {
		return dao.select(id);
	}
}
