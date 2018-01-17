package com.mul.product.controller;

import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mul.product.dao.ProductDao;
import com.mul.product.model.Product;
import com.mul.product.service.ProductService;

@Controller
public class ProductWebController 
{
	private static final String UPLOAD_FOLDER = "/upload";
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String list(Model model)
	{
		List<Product> list = null;
		
		list = productService.list();
		model.addAttribute("list", list);
		
		return "product";
	}
	
	@RequestMapping(value = "/product-detail", method = RequestMethod.GET)
	public String detail(Model model, 
			@RequestParam(value = "no", required=true)Integer no)
	{
		Product product = null;
		String filename = null;
		
		product = productService.detail(no);
		filename = product.getUri();
		
		if(filename != null && !filename.trim().isEmpty())
		{
			filename = URLDecoder.decode(filename, "UTF-8");
		}
		
		model.addAttribute("productitem", product);
		model.addAttribute("productimage", filename);
		
		return "product-detail";
	}
	
	@RequestMapping( value="/product-write", method = RequestMethod.GET)
	public String newProduct(Model model)
	{
		model.addAttribute("")
	}
}
