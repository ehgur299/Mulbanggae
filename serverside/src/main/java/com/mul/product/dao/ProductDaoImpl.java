package com.mul.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mul.product.model.CommonException;
import com.mul.product.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao
{
	
	private static final String MAPPER_PRODUCT = ProductDao.class.getName();
	
	@Autowired
	private SqlSession sqlSession;
	
	public ProductDaoImpl() {}
	
	@Override
	public void insert(Product product) 
	{
		sqlSession.insert(MAPPER_PRODUCT + ".insert" , product);
	}

	@Override
	public Product select(Integer no) 
	{	
		return sqlSession.selectOne(MAPPER_PRODUCT + ".select" , no);	
	}

	@Override
	public List<Product> selectAll() 
	{
		return sqlSession.selectList(MAPPER_PRODUCT + ".selectAll");
	}

	@Override
	public int productCount() {

		return sqlSession.selectOne(MAPPER_PRODUCT + ".count");
	}

	@Override
	public void update(Product product) 
	{
		sqlSession.update(MAPPER_PRODUCT + ".update", product);
	}

	@Override
	public void delete(Integer no) {
		// TODO Auto-generated method stub
		sqlSession.delete(MAPPER_PRODUCT + ".delete", no);
	}

	@Override
	public List<Product> selectByTitle(String title) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectByPrice(int minPrice, int maxPrice) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

}
