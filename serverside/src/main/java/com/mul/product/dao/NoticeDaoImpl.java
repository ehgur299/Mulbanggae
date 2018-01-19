package com.mul.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mul.product.model.CommonException;
import com.mul.product.model.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	private static final String MAPPER_NAMESPACE = NoticeDaoImpl.class.getName();
	
	@Autowired
	private SqlSession sqlSession;
	
	public NoticeDaoImpl() {}
	
	@Override
	public void insert(Notice notice) throws CommonException {
		try {
		sqlSession.insert(MAPPER_NAMESPACE + ".insert", notice);
		
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E04: 게시물 등록 실패");
		}
	}

	@Override
	public Notice select(String no) throws CommonException {
		Notice notice = null;
		
		try {
			notice = sqlSession.selectOne(MAPPER_NAMESPACE + ".select", no);
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E01: 게시물 검색 실패");
		}
		
		return notice;
	}

	@Override
	public List<Notice> selectAll() throws CommonException {
		List<Notice> list = null;
		
		try {
			list = sqlSession.selectList(MAPPER_NAMESPACE + ".selectAll");
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E02: 게시물 전체 검색 실패");
		}
		
		return list;
	}

	@Override
	public int NoticeCount() throws CommonException {
		Integer count = 0;
		
		try {
			count = sqlSession.selectOne(MAPPER_NAMESPACE + ".count");
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E09: 글 개수 가져오기 실패");
		}
		
		return count;
	}

	@Override
	public void update(Notice notice) throws CommonException {
		
		try {
			sqlSession.update(MAPPER_NAMESPACE + ".update", notice);
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E07: 게시물 수정 실패");
		}
	}

	@Override
	public void delete(String no) throws CommonException {
		try {
			sqlSession.delete(MAPPER_NAMESPACE + ".delete", no);
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E08: 게시물 삭제 실패");
		}
	}

}
