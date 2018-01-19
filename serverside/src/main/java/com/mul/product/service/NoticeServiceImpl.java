package com.mul.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mul.product.dao.NoticeDao;
import com.mul.product.model.CommonException;
import com.mul.product.model.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao dao;
	
	public NoticeServiceImpl() {}
	
	@Override
	public void newNotice(Notice notice) throws CommonException {
		// DB에 저장
		dao.insert(notice);
		
	}

	@Override
	public Notice detail(String no) throws CommonException {
		return dao.select(no);
	}

	@Override
	public List<Notice> list() throws CommonException {
		return dao.selectAll();
	}
	
	@Override
	public int count() throws CommonException {
		return dao.NoticeCount();
	}

	@Transactional
	@Override
	public String modify(Notice notice) throws CommonException {
		/*
		 * 파라미터의 notice 객체는 이미 수정된 정보를 담고있다.
		 * 따라서 기존 데이터베이스에서 글번호로 기존 데이터를 불러온다.
		 */
		Notice item = dao.select(Integer.toString(notice.getNo()));
		String oldFilename = item.getUrl();
		dao.update(notice);
		
		return oldFilename;
	}

	@Transactional
	@Override
	public String remove(String no) throws CommonException {
		Notice item = dao.select(no);
		String filename = item.getUrl();
		dao.delete(no);
		
		return filename;
	}
}
