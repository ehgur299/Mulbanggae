package com.mul.product.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mul.product.service.FileService;
import com.mul.product.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeWebController {

	private static final String UPLOAD_FOLDER = "/upload";
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private UserInfoService
}
