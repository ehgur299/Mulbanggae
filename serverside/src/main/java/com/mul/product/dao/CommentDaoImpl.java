package com.mul.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mul.product.model.Comment;
import com.mul.product.model.CommonException;

@Repository
public class CommentDaoImpl implements CommentDao {

	private static final String MAPPER_COMMENT = CommentDao.class.getName();
	
	@Autowired
	private SqlSession sqlSession;
	
	public CommentDaoImpl() {}
	
	@Override
	public void insert(Comment comment) throws CommonException 
	{
		sqlSession.insert(MAPPER_COMMENT + ".insert", comment);
		// TODO Auto-generated method stub
	}

	@Override
	public Comment select(String no) throws CommonException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(MAPPER_COMMENT + ".select", no);
	}

	@Override
	public List<Comment> selectAll() throws CommonException {
		// TODO Auto-generated method stub
		return sqlSession.selectList(MAPPER_COMMENT + ".selectAll");
	}

	@Override
	public int commentCount() throws CommonException 
	{
		return sqlSession.selectOne(MAPPER_COMMENT + ".count");
	}

	@Override
	public void modify(String no) throws CommonException {
		// TODO Auto-generated method stub
		sqlSession.update(MAPPER_COMMENT + "update", no);
	}

	@Override
	public void delete(String no) throws CommonException {
		// TODO Auto-generated method stub
		sqlSession.delete(MAPPER_COMMENT + "delete", no);
	}

}
