package com.mul.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mul.product.dao.CommentDao;
import com.mul.product.dao.UserInfoDao;
import com.mul.product.model.Comment;
import com.mul.product.model.UserInfo;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao dao;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public CommentServiceImpl() {}
	
	@Override
	public void newComment(Comment comment) {
		// TODO Auto-generated method stub
		dao.insert(comment);
	}

	@Override
	public Comment detail(Integer no) {
		// TODO Auto-generated method stub
		return dao.select(no.toString());
	}

	@Override
	public List<Comment> list() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.commentCount();
	}

	@Override
	public String modify(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer no) {
		// TODO Auto-generated method stub
		
		dao.modify(no.toString());
		return null;
	}

	@Override
	public boolean isCommentMatced(Integer no, String password) {
		// TODO Auto-generated method stub
		
		Comment comment = dao.select(no.toString());
		UserInfo userInfo = userInfoDao.select(comment.getUser_no());
		
		return encoder.matches(password, userInfo.getPwd());
	}

}
