package com.mul.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mul.product.model.Comment;
import com.mul.product.model.CommonException;
import com.mul.product.model.Product;

@Repository
public class CommentDaoImpl implements CommentDao {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	private static final String MAPPER_NAMESPACE = CommentDaoImpl.class.getName();
	
	@Autowired
	private SqlSession sqlSession;
	
	public CommentDaoImpl() {}
	
	@Override
	public void insert(Comment comment) throws CommonException 
	{
		sqlSession.insert(MAPPER_NAMESPACE + ".insert", comment);
		// TODO Auto-generated method stub
	}

	@Override
	public List<Comment> selectAll() throws CommonException {
		// TODO Auto-generated method stub
		return sqlSession.selectList(MAPPER_NAMESPACE + ".selectAll");
	}

	@Override
	public void update(Comment comment) throws CommonException {
		// TODO Auto-generated method stub
		sqlSession.update(MAPPER_NAMESPACE + "update", comment);
	}

	@Override
	public void delete(String no) throws CommonException {
		// TODO Auto-generated method stub
		sqlSession.delete(MAPPER_NAMESPACE + "delete", no);
	}

	@Override
	public Comment select(String no) throws CommonException {
		Comment comment = null;
		
		try {
			comment = sqlSession.selectOne(MAPPER_NAMESPACE + ".select", no);
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CommonException("E01: 댓글 검색 실패");
		}
		
		return comment;
	}
	
	public List<Comment> selectbyProduct(String no) throws CommonException
	{
		List<Comment> list = null;
		
		list = sqlSession.selectList(MAPPER_NAMESPACE + ".selectbyProduct",Integer.parseInt(no));
		
		return list;
	}

}
