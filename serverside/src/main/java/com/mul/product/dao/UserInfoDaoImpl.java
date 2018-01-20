package com.mul.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mul.product.model.CommonException;
import com.mul.product.model.UserInfo;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	private Logger logger = LogManager.getLogger(this.getClass());

	private static final String MAPPER_NAMESPACE = UserInfoDaoImpl.class.getName();
	
	@Autowired
	private SqlSession sqlSession;
	
	public UserInfoDaoImpl() {}
	
	@Override
	public List<UserInfo> selectAll() throws CommonException {
		List<UserInfo> list = null;
		
		try {
			list = sqlSession.selectList(MAPPER_NAMESPACE + ".selectAll");
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E30: 사용자 전체 검색 실패");
		}
		
		return list;
	}

	@Override
	public UserInfo select(Integer uid) throws CommonException {
		UserInfo userInfo = null;
		
		try {
			userInfo = sqlSession.selectOne(MAPPER_NAMESPACE + ".select", uid);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException("E31: 사용자 검색 실패");
		}
		
		return userInfo;
	}

	@Override
	public void insert(UserInfo user) throws CommonException {
		try {
			sqlSession.insert(MAPPER_NAMESPACE + ".insert", user); 

		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new CommonException("E32: 사용자 등록 실패");
		}
	}

	@Override
	public void insertUserTypes(UserInfo user) throws CommonException {
		try {
			sqlSession.insert(MAPPER_NAMESPACE + ".insertUserTypes", user);

		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E33: 사용자 타입 등록 실패");
		}
	}

	@Override
	public void delete(Integer uid) throws CommonException {
		try {
			sqlSession.delete(MAPPER_NAMESPACE+ ".delete", uid);

		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E35: 사용자 삭제 실패");
		}
		
	}

	@Override
	public void deleteUserTypes(Integer uid) throws CommonException {
		try {
			sqlSession.delete(MAPPER_NAMESPACE+ ".deleteUserTypes", uid);

		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E36: 사용자 타입 삭제 실패");
		}
	}

	@Override
	public void update(UserInfo user) throws CommonException {
		try {
			sqlSession.update(MAPPER_NAMESPACE + ".update", user);

		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E37: 사용자 수정 실패");
		}
	}

	@Override
	public UserInfo SelectByNickname(String nickname) throws CommonException {
		UserInfo userInfo = null;

		try {
			userInfo = sqlSession.selectOne(MAPPER_NAMESPACE + ".selectByNickname", nickname);

		} catch (Exception e) {
			e.printStackTrace();
			//logger.debug(e.getMessage());
			throw new CommonException("E38: 사용자 검색 실패");
		}

		return userInfo;
	}
}