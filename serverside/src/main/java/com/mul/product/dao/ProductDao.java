package com.mul.product.dao;

import java.util.List;

import com.mul.product.model.CommonException;
import com.mul.product.model.Product;

public interface ProductDao {

	// 글 등록
	public void insert(Product product) throws CommonException;
	
	// 글 하나 가져오기
	public Product select(String no) throws CommonException;
	
	// 전체 글 가져오기
	public List<Product> selectAll() throws CommonException;
	
	// 전체 글 개수 가져오기
	public int ProductCount() throws CommonException;
	
	// 글 수정하기
	public void update(Product product) throws CommonException;
	
	// 글 삭제하기
	public void delete(String no) throws CommonException;
	
}
