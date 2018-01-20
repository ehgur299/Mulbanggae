package com.mul.product.service;

import com.mul.product.model.UserType;

public interface UserTypeService {

	// 타입 인덱스 값으로 UserType 가져오기
	UserType findById(Integer id);

}
