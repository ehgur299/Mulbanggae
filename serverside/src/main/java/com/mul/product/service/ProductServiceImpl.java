package com.mul.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mul.product.dao.ProductDao;
import com.mul.product.dao.UserInfoDao;
import com.mul.product.model.Product;
import com.mul.product.model.UserInfo;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao dao;
	
	@Autowired
	private UserInfoDao infoDao;
	
	@Autowired
	private PasswordEncoder encoder;
	
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
	public String modify(Product product) 
	{
		Product item = dao.select(product.getNo());
		dao.update(product);
		
		return item.getUrl();
	}
	
	@Transactional
	@Override
	public String delete(Integer no) 
	{
		Product item = dao.select(no);
		
		dao.delete(no);
		
		return item.getUrl();
	}

	@Override
	public boolean isProductMatced(Integer no, String password) {
		
		Product product = dao.select(no);
		UserInfo userInfo = infoDao.select(product.getNo());
		
		return encoder.matches(password, userInfo.getPwd());
	}

}
