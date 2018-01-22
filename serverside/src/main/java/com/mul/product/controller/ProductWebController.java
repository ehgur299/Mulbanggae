package com.mul.product.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
import org.springframework.web.multipart.MultipartFile;

import com.mul.product.dao.ProductDao;
import com.mul.product.model.CommonException;
import com.mul.product.model.Product;
import com.mul.product.service.FileService;
import com.mul.product.service.ProductService;
import com.mul.product.service.UserInfoService;

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
			@RequestParam(value = "no", required=true)String no) throws CommonException,UnsupportedEncodingException
	{
		Product product = null;
		String filename = null;
		
		product = productService.detail(Integer.parseInt(no));
		filename = product.getUrl();
		
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
		String id = this.getPrincipal();
		Product item = productService.detail(Integer.parseInt(id));
		
		model.addAttribute("productitem", item.getNo());
		model.addAttribute("producttitle", item.getTitle());
		
		return "product-write";
	}
	
	@RequestMapping( value="/product-write", method = RequestMethod.POST)
	public String newProduct(HttpServletRequest request,
			Integer no,
			String title,
			String name,
			String price,
			String content,
			@RequestParam("url") MultipartFile url,
			String m_ctg,
			String md_ctg)
				throws CommonException, IllegalStateException, IOException
		{
			Product product = new Product();
			product.setNo(no);
			product.setTitle(title);
			product.setName(name);
			product.setContent(content);
			product.setPrice(price);
			product.setM_ctg(m_ctg);
			product.setMd_ctg(md_ctg);
			
			String path = request.getServletContext().getRealPath(UPLOAD_FOLDER);
			
			String originalName = url.getOriginalFilename();
			
			File dir = new File(path);
			
			if( !dir.exists())
				{
					dir.mkdirs();
				}
			
			if(url != null && !url.isEmpty())
				{
					int idx = originalName.lastIndexOf(".");
					String filename = originalName.substring(0, idx);
					String ext = originalName.substring(idx, originalName.length());
					String uploadFilename = filename +
											Long.toHexString(System.currentTimeMillis()) +
											ext;
					url.transferTo(new File(path, uploadFilename));
					uploadFilename = URLEncoder.encode(uploadFilename, "UTF-8");
					product.setUrl(uploadFilename);
				}
			
			productService.newProduct(product);
			
			return "redirect:/product";
		}
	
	@RequestMapping(value="/product-remove", method = RequestMethod.POST)
	public String remove(HttpServletRequest request,
						 @RequestParam(value = "no", required = true) String no,
						 String password) throws CommonException, UnsupportedEncodingException
		{
			boolean isMatched = productService.isProductMatced(Integer.parseInt(no), password);
			if(!isMatched)
			{
				return "redirect:/product/product-remove?no=" + no + "&action=error-password";
			}
			
			String filename = productService.delete(Integer.parseInt(no));
			if(filename != null && !filename.trim().isEmpty())
			{
				fileService.remove(request, UPLOAD_FOLDER, filename);
			}
			
			
			return "redirect:/product";
		}
	
	@RequestMapping(value="/product-modify", method = RequestMethod.GET)
	public String modify(Model model, @RequestParam(value = "no", required = true) String no)
	{
		Product item = null;
		
		item = productService.detail(Integer.parseInt(no));
		
		model.addAttribute("productitem",item);
		
		return "product-modify";
	}
	
	@RequestMapping(value="/product-modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request,
			int no,
			String title,
			String content,
			String name,
			String price,
			String m_ctg,
			String md_ctg,
			@RequestParam("url") MultipartFile url,
			String password) throws IllegalStateException, IOException
	{
		boolean isMatched = productService.isProductMatced(no, password);
		if(!isMatched)
		{
			return "redirect:/product/product-modify.do?no=" + no + "&action=error-password";
		}
		
		Product product = new Product();
		product.setNo(no);
		product.setTitle(title);
		product.setName(name);
		product.setPrice(price);
		product.setM_ctg(m_ctg);
		product.setMd_ctg(md_ctg);
		
		String path = request.getServletContext().getRealPath(UPLOAD_FOLDER);
		String originalName = url.getOriginalFilename();
		
		if(url != null && !url.isEmpty())
		{
			int idx = originalName.lastIndexOf(".");
			String filename = originalName.substring(0, idx);
			String ext = originalName.substring(idx, originalName.length());
			String uploadFilename = filename +
									Long.toHexString(System.currentTimeMillis()) +
									ext;
			url.transferTo(new File(path, uploadFilename));
			uploadFilename = URLEncoder.encode(uploadFilename, "UTF-8");
			product.setUrl(uploadFilename);
		}
		return "redirect:product";
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
