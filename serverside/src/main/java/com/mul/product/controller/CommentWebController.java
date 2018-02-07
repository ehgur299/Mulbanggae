package com.mul.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mul.product.model.Comment;
import com.mul.product.model.CommonException;
import com.mul.product.model.UserInfo;
import com.mul.product.service.CommentService;
import com.mul.product.service.UserInfoService;

@Controller
@RequestMapping("/comment")
public class CommentWebController 
{
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	// 글 목록 화면
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws CommonException
	{
		List<Comment> comment = null;
		
		comment = commentService.selectAll();
		
		model.addAttribute("comment", comment);
		return "list";
	}
	
	@RequestMapping(value = "/comment-new", method = RequestMethod.GET)
	public String commentWrite(Model model)
	{
		String id = this.getPrincipal();
		UserInfo userInfo = userInfoService.detail(id);
		
		model.addAttribute("no",userInfo.getNo());
		model.addAttribute("nickname", userInfo.getNickname());
		return "comment-new";
	}
	
	@RequestMapping(value = "/comment-new", method = RequestMethod.POST)
	public String commentWrite(HttpServletRequest request,
			Integer no,
			Integer product_num,
			String cmt_content)
					throws CommonException, Exception {
		
		Comment comment = new Comment();
		comment.setUser_num(no);
		comment.setProduct_num(product_num);
		comment.setCmt_content(cmt_content);
		
		return "redirect:/product/product-detail.do?no=" + product_num;
	}
	
	@RequestMapping(value = "/comment-modify", method = RequestMethod.GET)
	public String commentModify(Model model,
			@RequestParam(value = "no", required= true) String no)
					throws CommonException {
	
		Comment comment = null;
		
		comment = commentService.detail(no);
		
		model.addAttribute("comment", comment);
		
		return "modify";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String commentModify(HttpServletRequest request,
			String product_no,String user_no,String content
			)
	{
		Comment comment = null;
		comment.setCmt_content(content);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String commentDelete(Model model, @RequestParam(value = "no", required=true)String no)
	{
		
		model.addAttribute("no", no);
		
		return "delete";
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
