package com.mul.product.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mul.product.model.CommonException;
import com.mul.product.model.Product;
import com.mul.product.model.UserInfo;
import com.mul.product.service.FileService;
import com.mul.product.service.ProductService;
import com.mul.product.service.UserInfoService;

@Controller
@RequestMapping("/product")
public class ProductWebController {
	
	private static final String UPLOAD_FOLDER = "/upload";
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value = "/product.do", method = RequestMethod.GET)
	public String list(Model model) throws CommonException {
		
		UserInfo item = null;
		
		String id = this.getPrincipal();
		item = userInfoService.detail(id);
		
		model.addAttribute("item", item);
		
		List<Product> product = null;
		
		product = productService.list();
		
		logger.debug(product);
		
		model.addAttribute("product", product);
		return "product";
	}
	
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String detail(Model model, 
			@RequestParam(value = "no", required=true)String no) throws CommonException,UnsupportedEncodingException
	{
		Product product = null;
		String filename = null;
		
		product = productService.detail(no);
		filename = product.getUrl();
		
		if(filename != null && !filename.trim().isEmpty()) {
			filename = URLDecoder.decode(filename, "UTF-8");
		}
		
		model.addAttribute("item", product);
		model.addAttribute("filename", filename);
		
		return "product_detail";
	}
	
	@RequestMapping( value="/product-new.do", method = RequestMethod.GET)
	public String newProduct(Model model)
	{
		UserInfo item = null;
		
		String id = this.getPrincipal();
		item = userInfoService.detail(id);
		
		model.addAttribute("item", item);
		
		return "product-new";
	}
	
	@RequestMapping( value="/product-new.do", method = RequestMethod.POST)
	public String newProduct(HttpServletRequest request,
			Integer no,
			String title,
			String productname,
			String price,
			String content,
			@RequestParam("url") MultipartFile url,
			String m_ctg
			)
				throws CommonException, IllegalStateException, IOException
		{
			Product product = new Product();
			product.setUser_no(no);
			product.setTitle(title);
			product.setProductname(productname);
			product.setContent(content);
			product.setPrice(price);
			product.setM_ctg(m_ctg);
			
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
			
			return "redirect:/product.do";
		}
	@RequestMapping(value="/product-remove.do", method = RequestMethod.GET)
	public String remove(Model model, @RequestParam(value = "no", required = true) String no)
	{
		model.addAttribute("no",no);
		
		return "product-remove";
	}
	
	@RequestMapping(value="/product-remove.do", method = RequestMethod.POST)
	public String remove(HttpServletRequest request,
						 @RequestParam(value = "no", required = true) String no,
						 String password) throws CommonException, UnsupportedEncodingException
		{
			boolean isMatched = userInfoService.isProductMatched(no, password);
			if(!isMatched)
			{
				return "redirect:/product/product-remove?no=" + no + "&action=error-password";
			}
			
			String filename = productService.delete(no);
			if(filename != null && !filename.trim().isEmpty())
			{
				fileService.remove(request, UPLOAD_FOLDER, filename);
			}
			
			
			return "redirect:/product.do";
		}
	
	@RequestMapping(value="/product-modify", method = RequestMethod.GET)
	public String modify(Model model, @RequestParam(value = "no", required = true) String no)
	{
		Product item = null;
		
		item = productService.detail(no);
		
		model.addAttribute("productitem",item);
		
		return "modify";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request,
			String no,
			String title,
			String content,
			String productname,
			String price,
			String m_ctg,
			@RequestParam("url") MultipartFile url,
			String password) throws IllegalStateException, IOException
	{
		boolean isMatched = userInfoService.isProductMatched(no, password);
		if(!isMatched)
		{
			return "redirect:/product/product-modify.do?no=" + no + "&action=error-password";
		}
		
		Product product = new Product();
		product.setNo(no);
		product.setTitle(title);
		product.setProductname(productname);
		product.setPrice(price);
		product.setM_ctg(m_ctg);
		
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
		return "redirect:product.do";
	}
	
	// 파일 내려받기
		@RequestMapping(value = "/download.do", method = RequestMethod.GET, params="filename")
		public void download(HttpServletRequest request, 
				HttpServletResponse response, String filename)
						throws CommonException {
			
			int length = 0;
			byte[] buff = new byte[1024];
			
			// 서버에 저장된 파일 경로 불러오기
			String directory = request.getServletContext().getRealPath(UPLOAD_FOLDER);

			// 요청한 파일명으로 실제 파일을 객체화 하기
			File file = new File(directory, filename);

			FileInputStream fis = null;
			BufferedOutputStream bos = null;
			try {
				fis = new FileInputStream(file);

				// 다운받을 때, 한글 깨짐현상 수정
				filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");

				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", 
						"attachment; filename=" + filename + ";");
				response.setHeader("Content-Transfer-Encoding", "binary");
				response.setHeader("Content-Length", Integer.toString(fis.available()));
				response.setHeader("Pragma", "no-cache");
				response.setHeader("Expires", "-1");

				/*
				 * Connection Stream: ServletOutputStream
				 * Chain Stream: BufferedOutputStream
				 */
				bos = new BufferedOutputStream(response.getOutputStream());

				// 서버에 있는 파일을 읽어서 (fis), 클라이언트에게 파일을 전송(bos)
				while ( (length = fis.read(buff)) > 0) {
					bos.write(buff, 0, length);
				}

				// 변기 물내린다는 뜻, 버퍼에 남아있는 정보를 보내준다.
				bos.flush();

			} catch (Exception e) {
				throw new CommonException("E12: 파일 내려받기 실패");

			} finally {
				try {
					bos.close();
					fis.close();

				} catch (IOException e) {
					logger.debug(e.getMessage());
				}
			}
		}
		
		@ExceptionHandler(CommonException.class)
		public String handleException(CommonException e) {
			logger.debug(e.getMessage());
			return "exception";
		}

		@ExceptionHandler(Exception.class)
		public String handleException(Exception e) {
			logger.debug(e.getMessage());
			return "exception-common";
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
