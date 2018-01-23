package com.mul.product.dao;

import java.util.List;

import com.mul.product.model.CommonException;
import com.mul.product.model.Product;

public interface ProductDao 
{
	public void insert(Product product) throws CommonException;
	
	public Product select(Integer no) throws CommonException;
	
	public List<Product> selectByTitle(String title) throws CommonException;
	
	public List<Product> selectByPrice(int minPrice, int maxPrice) throws CommonException;
	
	public List<Product> selectAll() throws CommonException;
	
	public int productCount() throws CommonException;
	
	public void update(Product product) throws CommonException;
	
	public void delete(Integer no) throws CommonException;
}
