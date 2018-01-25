package com.mul.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mul.product.model.CommonException;
import com.mul.product.model.Rating;

@Repository
public class RatingDaoImpl implements RatingDao 
{
	private static String MAPPER_RATING = RatingDao.class.getName();
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(Rating rating) throws CommonException 
	{
		sqlSession.insert(MAPPER_RATING + ".insert", rating);
		
	}

	@Override
	public void select(String no) throws CommonException {
		
		sqlSession.selectOne(MAPPER_RATING + ".select", no);
	}

	@Override
	public List<Rating> selectAll() throws CommonException {
		
		return sqlSession.selectList(MAPPER_RATING + ".selectAll");
	}

	@Override
	public int count() throws CommonException {
		return sqlSession.selectOne(MAPPER_RATING + ".count");
	}

	@Override
	public void modify(Rating rating) throws CommonException 
	{
		sqlSession.update(MAPPER_RATING + ".modify", rating);
	}

	@Override
	public void delete(String no) throws CommonException 
	{
		// TODO Auto-generated method stub
		sqlSession.delete(MAPPER_RATING + ".delete", no);
	}

}
