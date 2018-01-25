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
@RequestMapping("/comment/*")
public class CommentWebController 
{
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws CommonException
	{
		List<Comment> comment = null;
		
		comment = commentService.list();
		
		model.addAttribute("comment", comment);
		return "list";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String commentWrite(Model model)
	{
		String id = this.getPrincipal();
		UserInfo userInfo = userInfoService.detail(id);
		
		model.addAttribute("no",userInfo.getNo());
		model.addAttribute("nickname", userInfo.getNickname());
		return "write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String commentWrite(HttpServletRequest request,
							   Integer product_no,
							   String content
							   )
	{
		Comment comment = null;
		comment.setProduct_no(product_no);
		comment.setCmt_content(content);
		String id = this.getPrincipal();
		UserInfo userInfo = userInfoService.detail(id);
		comment.setUser_no(Integer.parseInt(userInfo.getId()));
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String commentModify(Model model,@RequestParam(value = "no", required= true)String no)
	{
		Comment comment = null;
		
		comment = commentService.detail(Integer.parseInt(no));
		
		model.addAttribute("comment", comment);
		
		return "modify";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String commentModify(HttpServletRequest request,
			String product_no,String user_no,String content
			)
	{
		Comment comment = null;
		comment.setProduct_no(Integer.parseInt(product_no));
		comment.setCmt_content(content);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String commentDelete(Model model, @RequestParam(value = "no", required=true)String no)
	{
		
		model.addAttribute("no", no);
		
		return "delete";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String commentDelete(HttpServletRequest request,
			@RequestParam(value="no", required = true) String no,
			String password)
	{
		boolean isMatched = commentService.isCommentMatced(Integer.parseInt(no), password);
		
		if(!isMatched)
		{
			return "redirect:/comment/delete?no=" + no + "&action=error-password";
		}
		
		commentService.delete(Integer.parseInt(no));
		
		return "redirect:/list";
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
