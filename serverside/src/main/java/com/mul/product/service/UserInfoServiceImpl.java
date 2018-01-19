package com.mul.product.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mul.product.dao.NoticeDao;
import com.mul.product.dao.UserInfoDao;
import com.mul.product.model.CommonException;
import com.mul.product.model.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserInfo detail(Integer uid) throws CommonException {
		return userInfoDao.select(uid);
	}

	@Transactional
	@Override
	public void newUser(UserInfo userInfo) throws CommonException {
		
		userInfo.setPwd(encoder.encode(userInfo.getPwd()));
		
		
	}

	@Override
	public String delete(String pwd) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modify(UserInfo userInfo) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isProductMatched(Integer no, String rawPassword) throws CommonException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPasswordMatched(Integer uid, String oldPassword) throws CommonException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo detail(String nickname) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String id, String password) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPasswordMatched(String id, String rawPassword) throws CommonException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
