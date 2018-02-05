package com.mul.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mul.product.dao.ProductDao;
import com.mul.product.model.CommonException;
import com.mul.product.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	public ProductServiceImpl() {}
	
	@Override
	public void newProduct(Product product) throws CommonException {
		// DB에 저장
		dao.insert(product);
		
	}

	@Override
	public Product detail(String no) throws CommonException {
		return dao.select(no);
	}

	@Override
	public List<Product> list() throws CommonException {
		return dao.selectAll();
	}

	@Override
	public int count() throws CommonException {
		return dao.ProductCount();
	}

	@Transactional
	@Override
	public String modify(Product product) throws CommonException {
		/*
		 * 파라미터의 notice 객체는 이미 수정된 정보를 담고있다.
		 * 따라서 기존 데이터베이스에서 글번호로 기존 데이터를 불러온다.
		 */
		Product item = dao.select(Integer.toString(product.getNo()));
		String oldFilename = item.getUrl();
		dao.update(product);
		
		return oldFilename;
	}

	@Transactional
	@Override
	public String remove(String no) throws CommonException {
		Product item = dao.select(no);
		String filename = item.getUrl();
		dao.delete(no);
		
		return filename;
	}

}
