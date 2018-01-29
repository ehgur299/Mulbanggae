package com.mul.product.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mul.product.model.CommonException;
import com.mul.product.model.UserInfo;
import com.mul.product.service.UserInfoService;

@RestController
@RequestMapping("/rest")
public class UserRestController {

	private Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private PasswordEncoder encoder;

	// 사용자 로그인
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(UserInfo userInfo, 
			UriComponentsBuilder ucBuilder) {

		logger.debug(userInfo);

		// 아이디 존재 유무와 비밀번호 일치 여부 확인
		boolean isMatched = userInfoService.isPasswordMatched(
				userInfo.getId(),
				userInfo.getPwd());

		if (isMatched) {
			// Base64 인코딩 전 평문
			String plainCredentials = 
					userInfo.getId() + ":" + userInfo.getPwd();

			// 평문을 Base64로 인코딩
			String base64Credentials = 
					new String(
							Base64.encodeBase64(plainCredentials.getBytes()
									));

			logger.debug(base64Credentials);

			userInfo = userInfoService.detail(userInfo.getId());

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/rest/user/{id}")
					.buildAndExpand(userInfo.getId())
					.toUri());

			return new ResponseEntity<String>(base64Credentials, headers, HttpStatus.OK);
		}

		logger.debug("login failed");
		return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
	}

	// 사용자 생성
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Void> newUser(HttpServletRequest request,
			String id,
			String pwd,
			String gender,
			String birth,
			UriComponentsBuilder ucBuilder)
					throws CommonException, Exception {

		UserInfo user = new UserInfo();
		user.setId(id);
		user.setPwd(pwd);
		user.setGender(gender);
		user.setBirth(birth);

		userInfoService.newUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/rest/user/{id}")
				.buildAndExpand(user.getId())
				.toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// 사용자 불러오기
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET,
			produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, 
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserInfo> homePage(@PathVariable("no") Integer no, 
			UriComponentsBuilder ucBuilder) {

		// 로그인 된 상태이면
		UserInfo item = null;
		if (no != null) {
			item = userInfoService.detail(no);

		}

		return new ResponseEntity<UserInfo>(new UserInfo(), HttpStatus.NO_CONTENT);
	}

	// 사용자 수정
	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> modify(HttpServletRequest request,
			@PathVariable("no") Integer no,
			String oldPassword,
			String newPassword,
			String nickname)
					throws CommonException,Exception {

		// 기존 비밀번호 검사 후 수정할지 결정
		boolean isMatched = userInfoService.isPasswordMatched(no, oldPassword);
		if (!isMatched) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}

		UserInfo user = new UserInfo();
		user.setNo(no);
		user.setPwd(encoder.encode(newPassword));
		user.setNickname(nickname);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 사용자 삭제 (탈퇴)
	@RequestMapping(value = "/user/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(HttpServletRequest request,
			@PathVariable("no") String no,
			@RequestHeader("Authorization") String authorization)
					throws CommonException, UnsupportedEncodingException {
		
		// 1. "Basic " 떼어내기
		String base64Credentials = authorization.split(" ")[1];
		
		// 2. base64 인코딩 했던 부분을 디코딩 -> email:password
		String[] idPassword = new String(Base64.decodeBase64(base64Credentials)).split(":");
		
		// 3. 배열에 들어가 있는 email, password 값을 각자의 변수에 담기
		String id = idPassword[0];
		String pwd = idPassword[1];
		
		String filename = userInfoService.delete(id, pwd);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
