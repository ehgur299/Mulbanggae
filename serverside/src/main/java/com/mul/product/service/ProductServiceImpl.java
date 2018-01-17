package com.mul.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mul.product.dao.ProductDao;
import com.mul.product.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao dao;
	
	public ProductServiceImpl() {}
	
	@Override
	public void newProduct(Product product) {
		// TODO Auto-generated method stub
		dao.insert(product);
	}

	@Override
	public Product detail(Integer no) {
		// TODO Auto-generated method stub
		return dao.select(no);
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.productCount();
	}
	
	@Transactional
	@Override
	public void modify(Product product) 
	{
		dao.update(product);
	}
	
	@Transactional
	@Override
	public void delete(Integer no) 
	{
		dao.delete(no);
	}

}
