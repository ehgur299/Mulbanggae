package com.mul.product.dao;

import java.util.List;

import com.mul.product.model.CommonException;
import com.mul.product.model.Rating;

public interface RatingDao 
{
	public void insert(Rating rating) throws CommonException;
	
	public Rating select(String no) throws CommonException;
	
	public List<Rating> selectAll() throws CommonException;
	
	public int count() throws CommonException;
	
	public void modify(Rating rating) throws CommonException;

	public void delete(String no) throws CommonException;
}
