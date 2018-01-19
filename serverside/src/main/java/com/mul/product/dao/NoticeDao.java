package com.mul.product.dao;

import java.util.List;

import com.mul.product.model.CommonException;
import com.mul.product.model.Notice;

public interface NoticeDao {

	// 공지사항 글 등록
	public void insert(Notice notice) throws CommonException;
	
	// 공지사항 글 하나 가져오기
	public Notice select(String no) throws CommonException;
	
	// 전체 글 가져오기
	public List<Notice> selectAll() throws CommonException;
	
	// 전체 글 개수 가져오기
	public int NoticeCount() throws CommonException;
	
	// 글 수정하기
	public void update(Notice notice) throws CommonException;
	
	// 글 삭제하기
	public void delete(String no) throws CommonException;
}
