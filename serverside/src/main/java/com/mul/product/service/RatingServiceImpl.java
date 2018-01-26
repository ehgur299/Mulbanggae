package com.mul.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mul.product.dao.RatingDao;
import org.springframework.stereotype.Service;

import com.mul.product.model.CommonException;
import com.mul.product.model.Rating;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingDao dao;
	
	public RatingServiceImpl() {}
	
	@Override
	public void newRating(Rating rating) throws CommonException {
		// TODO Auto-generated method stub
		dao.insert(rating);
	}

	@Override
	public void modify(Rating rating) throws CommonException {
		// TODO Auto-generated method stub
		dao.modify(rating);
	}

	@Override
	public void delete(String no) throws CommonException {
		// TODO Auto-generated method stub
		dao.delete(no);
	}

	@Override
	public Rating detail(String no) throws CommonException {
		// TODO Auto-generated method stub
		return dao.select(no);
	}

	@Override
	public List<Rating> list() throws CommonException {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
