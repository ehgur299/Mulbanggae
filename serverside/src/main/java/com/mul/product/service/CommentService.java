package com.mul.product.service;

import java.util.List;

import com.mul.product.model.Comment;
import com.mul.product.model.CommonException;
import com.mul.product.model.Product;

public interface CommentService 
{
	// 글 등록
	public void insert(Comment comment) throws CommonException;
		
	// 전체 글 가져오기
	public List<Comment> selectAll() throws CommonException;
		
	// 글 수정하기
	public void update(Comment comment) throws CommonException;
		
	// 글 삭제하기
	public void delete(String no) throws CommonException;
	
	// 게시물 하나를 가져온다.
	public Comment detail(String no) throws CommonException;
		
	public List<Comment> selectbyProduct(String no) throws CommonException;
}
