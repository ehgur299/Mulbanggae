package com.mul.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mul.product.dao.ProductDao;
import com.mul.product.dao.UserInfoDao;
import com.mul.product.model.CommonException;
import com.mul.product.model.Product;
import com.mul.product.model.UserInfo;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao dao;
	
	public ProductServiceImpl() {}
	
	@Override
	public void newProduct(Product product) throws CommonException {
		// TODO Auto-generated method stub
		dao.insert(product);
	}

	@Override
	public Product detail(String no) throws CommonException {
		// TODO Auto-generated method stub
		return dao.select(no);
	}

	@Override
	public List<Product> list() throws CommonException {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public int count() throws CommonException {
		// TODO Auto-generated method stub
		return dao.productCount();
	}
	
	@Transactional
	@Override
	public String modify(Product product) throws CommonException 
	{
		Product item = dao.select(Integer.toString(product.getNo()));
		String oldFilename = item.getUrl();
		dao.update(product);
		
		return oldFilename;
	}
	
	@Transactional
	@Override
	public String delete(String no) throws CommonException 
	{
		Product item = dao.select(no);
		String filename = item.getUrl();
		dao.delete(no);
		
		return filename;
	}

}
