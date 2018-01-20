package com.mul.product.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mul.product.dao.NoticeDao;
import com.mul.product.dao.UserInfoDao;
import com.mul.product.model.CommonException;
import com.mul.product.model.Notice;
import com.mul.product.model.UserInfo;
import com.mul.product.model.UserType;
import com.mul.product.model.UserTypeId;

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
		
		UserType userType = new UserType(UserTypeId.USER.getUserTypeId(), UserTypeId.USER.name());
		Set<UserType> userTypes = new HashSet<>();
		userTypes.add(userType);
		
		userInfo.setUserType(userTypes);
		
		userInfoDao.insert(userInfo);
		userInfoDao.insertUserTypes(userInfo);
		
		
	}

	@Override
	public String delete(Integer no, String pwd) throws CommonException {
		
		UserInfo item = userInfoDao.select(no);
		
		boolean isMatched = encoder.matches(pwd, item.getPwd());
		if (isMatched) {
			userInfoDao.deleteUserTypes(no);
			userInfoDao.delete(no);
			
		} else {
			throw new CommonException("E60: 비밀번호가 동일하지 않아 삭제 실패");
		}
		return item.getNickname();
	}

	@Override
	public boolean isNoticeMatched(Integer no, String rawPassword) throws CommonException {
		/*
		 *  게시물 번호를 이용하여 게시물을 가져온 뒤
		 *  게시물의 작성자 id값을 획득한 후,
		 *  획득한 id값으로 사용자 정보를 가져와
		 *  해당 사용자의 비밀번호를 가져온다.
		 */
		Notice notice = noticeDao.select(no.toString());
		UserInfo userInfo = userInfoDao.select(notice.getNo());
		
		// 해당 사용자의 비밀번호와 입력한 비밀번호 비교한 결과 리턴
		return encoder.matches(rawPassword, userInfo.getPwd());
	}

	@Override
	public boolean isPasswordMatched(Integer uid, String rawPassword) throws CommonException {
		
		// 데이터베이스로부터 현재 사용자의 암호화된 비밀번호를 가져온다.
		UserInfo item = userInfoDao.select(uid);
		return encoder.matches(rawPassword, item.getPwd());
	}

	@Override
	public UserInfo detail(String id) throws CommonException {
		return userInfoDao.SelectById(id);
	}

	@Override
	public String delete(String id, String password) throws CommonException {
		UserInfo item = userInfoDao.SelectById(id);
		
		boolean isMatched = encoder.matches(password, item.getPwd());
		if (isMatched) {
			userInfoDao.deleteUserTypes(item.getNo());
			userInfoDao.delete(item.getNo());
			
		} else {
			throw new CommonException("E61: 비밀번호가 동일하지 않아 삭제 실패");
		}
		
		return item.getNickname();
	}

	@Override
	public boolean isPasswordMatched(String id, String rawPassword) throws CommonException {

		// 데이터베이스로부터 현재 사용자의 암호화된 비밀번호를 가져온다.
		UserInfo item = userInfoDao.SelectById(id);
		return encoder.matches(rawPassword, item.getPwd());
	}

	@Override
	public String modify(UserInfo userInfo) throws CommonException {
		
		UserInfo item = userInfoDao.select(userInfo.getNo());
		String oldFilename = item.getNickname();
		userInfoDao.update(userInfo);

		return oldFilename;
	}
	
}
