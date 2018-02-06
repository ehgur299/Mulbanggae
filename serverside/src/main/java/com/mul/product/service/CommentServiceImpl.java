package com.mul.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mul.product.dao.CommentDao;
import com.mul.product.model.Comment;
import com.mul.product.model.CommonException;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao dao;
	
	public CommentServiceImpl() {}

	@Override
	public void insert(Comment comment) throws CommonException {
		dao.insert(comment);
	}

	@Override
	public List<Comment> selectAll() throws CommonException {
		return dao.selectAll();
	}

	@Transactional
	@Override
	public void update(Comment comment) throws CommonException {
		
	}

	@Override
	public void delete(String no) throws CommonException {
		
	}

	@Override
	public Comment detail(String no) throws CommonException {
		return dao.select(no);
	}

}
