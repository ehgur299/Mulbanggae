package com.mul.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mul.product.model.Rating;
import com.mul.product.model.UserInfo;
import com.mul.product.service.RatingService;
import com.mul.product.service.UserInfoService;


@Controller
@RequestMapping(value = "/rating/*")
public class RatingWebController 
{
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Model model)
	{
		List<Rating> list = null;
		
		list = ratingService.list();
		model.addAttribute("ratinglist", list);
		
		return "rating";
	}
	
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public String newRating(Model model)
	{
		String id = this.getPrincipal();
		UserInfo userInfo = userInfoService.detail(id);
		
		model.addAttribute("ratingno", userInfo.getNo());
		model.addAttribute("ratingName", userInfo.getNickname());
		
		return "write";
	}
	
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
