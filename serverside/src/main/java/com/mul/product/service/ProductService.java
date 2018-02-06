package com.mul.product.service;

import java.util.List;

import com.mul.product.model.CommonException;
import com.mul.product.model.Paging;
import com.mul.product.model.Product;

public interface ProductService {
	
	// 게시물 번호를 1 증가하고 게시물을 등록한다.
	public void newProduct(Product product) throws CommonException;
	
	// 게시물 하나를 가져온다.
	public Product detail(String no) throws CommonException;
	
	// 게시물 전체를 가져온다.
	public List<Product> list() throws CommonException;
	
	// 게시물의 개수를 가져온다.
	public int count() throws CommonException;
	
	// 게시물 수정한다. (수정되기 전 파일명을 리턴)
	public String modify(Product product) throws CommonException;
	
	// 게시물을 삭제한다. (삭제하는 파일명을 리턴)
	public String remove(String no) throws CommonException;
	
	public List<Product> list(int offset, int pagingmax) throws CommonException;
}
