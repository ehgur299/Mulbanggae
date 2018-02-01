package com.mul.product.service;

import java.util.List;

import com.mul.product.model.CommonException;
import com.mul.product.model.Product;

public interface ProductService 
{
	public void newProduct(Product product) throws CommonException;
	
	public Product detail(String no) throws CommonException;
	
	public List<Product> list() throws CommonException;
	
	public int count() throws CommonException;
	
	public String modify(Product product) throws CommonException;
	
	public String delete(String no) throws CommonException;
	
}
