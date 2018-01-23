package com.mul.product.service;

import java.util.List;

import com.mul.product.model.Comment;

public interface CommentService 
{
	public void newComment(Comment comment);
	
	public Comment detail(Integer no);
	
	public List<Comment> list();
	
	public int count();
	
	public String modify(Comment comment);
	
	public String delete(Integer no);
	
	public boolean isCommentMatced(Integer no, String password);
}
