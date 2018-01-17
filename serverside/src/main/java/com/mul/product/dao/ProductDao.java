package com.mul.product.dao;

import java.util.List;

import com.mul.product.model.Product;

public interface ProductDao 
{
	public void insert(Product product);
	
	public Product select(Integer no);
	
	public List<Product> selectAll();
	
	public int productCount();
	
	public void update(Product product);
	
	public void delete(Integer no);
}
