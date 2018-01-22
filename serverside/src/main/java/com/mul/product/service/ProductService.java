package com.mul.product.service;

import java.util.List;

import com.mul.product.model.Product;

public interface ProductService 
{
	public void newProduct(Product product);
	
	public Product detail(Integer no);
	
	public List<Product> list();
	
	public int count();
	
	public String modify(Product product);
	
	public String delete(Integer no);
	
	public boolean isProductMatced(Integer no, String password);
}
