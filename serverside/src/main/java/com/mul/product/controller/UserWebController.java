package com.mul.product.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mul.product.model.CommonException;
import com.mul.product.model.UserInfo;
import com.mul.product.service.UserInfoService;

@Controller
public class UserWebController {

	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		
		String id = this.getPrincipal();
		
		if (id != null && !id.trim().isEmpty()) {
			UserInfo item = userInfoService.detail(id);
			model.addAttribute("userInfo", item);
		}
		
		return "main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "user/login";
	}
	
	@RequestMapping(value = "/logout" , method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login?action=logout";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		model.addAttribute("userInfo", this.getPrincipal());
		return "user/admin";
	}
	
	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String accessDeniedPage(Model model) {
		model.addAttribute("id", this.getPrincipal());
		return "user/access-denied";
	}
		
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinPage() {
		return "user/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String newUser(HttpServletRequest request,
			String id,
			String pwd,
			String nickname,
			String gender,
			String birth)
				throws CommonException, Exception {
		
		UserInfo user = new UserInfo();
		user.setId(id);
		user.setPwd(pwd);
		user.setNickname(nickname);
		user.setGender(gender);
		user.setBirth(birth);
		
		userInfoService.newUser(user);
		
		return "redirect:login";
	}
	
	@RequestMapping(value = "/user/mypage" , method = RequestMethod.GET)
	public String setting(Model model) {
		
		UserInfo item = null;
		
		String id = this.getPrincipal();
		item = userInfoService.detail(id);
		
		model.addAttribute("item", item);
		
		return "user/mypage";
	}

	@RequestMapping(value = "/user/delete" , method = RequestMethod.GET)
	public String delete() {
		return "user/delete";
	}
	
	@RequestMapping(value = "/user/delete" , method = RequestMethod.POST)
	public String delete(HttpServletRequest request, String password) throws CommonException, UnsupportedEncodingException {
		String id = this.getPrincipal();
		
		return "redirect:/logout";
	}
	
	// 사용자 수정하기 화면
	@RequestMapping(value = "/user/modify", method = RequestMethod.GET)
	public String modify(Model model) throws CommonException {
		
		UserInfo item = null;
		
		String id = this.getPrincipal();
		item = userInfoService.detail(id);
		
		model.addAttribute("item", item);
		
		return "user/modify";
	}
	
	// 사용자 수정 후, 사용자 설정 화면으로 이동
		@RequestMapping(value = "/user/modify", method = RequestMethod.POST)
		public String modify(HttpServletRequest request,
				Integer no,
				String oldPassword,
				String newPassword,
				String nickname)
					throws CommonException, Exception {
			
			// 기존 비밀번호 검사 후 수정할지 결정
			boolean isMatched = userInfoService.isPasswordMatched(no, oldPassword);
			if (!isMatched) {
				return "redirect:/user/modify?action=error-password";
			}
			
			UserInfo user = new UserInfo();
			user.setNo(no);
			user.setPwd(encoder.encode(newPassword));
			user.setNickname(nickname);
			
			userInfoService.modify(user);
			
			return "redirect:/user/mypage";
		}
		
		// 현재 접속한 사용자의 id 리턴
		private String getPrincipal() {
			String username = null;
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Object principal = auth.getPrincipal();

			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			}
			else {
				username = principal.toString();
			}

			return username;
		}

}
