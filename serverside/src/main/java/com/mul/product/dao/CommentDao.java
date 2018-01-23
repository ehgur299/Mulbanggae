package com.mul.product.dao;

import java.util.List;

import com.mul.product.model.Comment;
import com.mul.product.model.CommonException;

public interface CommentDao 
{
	public void insert(Comment comment) throws CommonException;
	
	public Comment select(String no) throws CommonException;
	
	public List<Comment> selectAll() throws CommonException;
	
	public int commentCount() throws CommonException;
	
	public void modify(String no) throws CommonException;
	
	public void delete(String no) throws CommonException;
}
