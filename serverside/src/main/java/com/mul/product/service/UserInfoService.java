package com.mul.product.service;

import com.mul.product.model.CommonException;
import com.mul.product.model.UserInfo;

public interface UserInfoService {

	public UserInfo detail(Integer uid) throws CommonException;
	
	public void newUser(UserInfo userInfo) throws CommonException;
	
	public String delete(Integer no, String pwd) throws CommonException;
	
	public String modify(UserInfo userInfo) throws CommonException;
	
	// 게시물 번호를 이용하여 게시물 작성자의 비밀번호와 입력한 비밀번호 비교
	public boolean isNoticeMatched(Integer no, String rawPassword) throws CommonException;
	
	// 현재 사용자의 user_number값을 이용하여 비밀번호를 불러온 다음, 입력한 비밀번호 비교
	public boolean isPasswordMatched(Integer uid, String oldPassword) throws CommonException;
	
	// CustomUserDetailService에서 ID 값으로 사용자를 검색할 때 사용
	public UserInfo detail(String id) throws CommonException;
	
	// password 값을 이용하여 사용자 삭제
	public String delete(String id, String password) throws CommonException;
	
	// 사용자의 id 값을 이용하여 비밀번호를 불러온 다음, 입력한 비밀번호와 비교
	boolean isPasswordMatched(String id, String rawPassword) throws CommonException;
}
