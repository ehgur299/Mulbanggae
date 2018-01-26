package com.mul.product.service;

import java.util.List;

import com.mul.product.model.CommonException;
import com.mul.product.model.Rating;

public interface RatingService 
{
	public void newRating(Rating rating) throws CommonException;
	
	public Rating detail(String no) throws CommonException;
	
	public List<Rating> list() throws CommonException;
	
	public void modify(Rating rating) throws CommonException;
	
	public void delete(String no) throws CommonException;
}
