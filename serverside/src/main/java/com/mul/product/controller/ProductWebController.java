package com.mul.product.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import com.mul.product.model.Paging;
import com.mul.product.model.Product;
import com.mul.product.model.UserInfo;
import com.mul.product.service.FileService;
import com.mul.product.service.ProductService;
import com.mul.product.service.UserInfoService;

@Controller
@RequestMapping("/product")
public class ProductWebController {
	
	private static final String UPLOAD_FOLDER = "/product";
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	// 글 목록 화면
		@RequestMapping(value = "/product.do", method = RequestMethod.GET)
		public String list(Model model, HttpServletRequest req) throws CommonException {
			
			List<Product> list = null;
			list = productService.list();
			
			UserInfo item = null;
			
			String id = this.getPrincipal();
			item = userInfoService.detail(id);
			
			model.addAttribute("item", item);
			
			logger.debug(list);
			
			model.addAttribute("product", list);
			return "product";
		}
		
		// 글 상세 화면
		@RequestMapping(value = "/product-detail.do", method = RequestMethod.GET)
		public String detail(Model model,
				@RequestParam(value = "no", required=true) String no)
						throws CommonException, Exception {
			
			String id = this.getPrincipal();
			
			if (id != null && !id.trim().isEmpty()) {
				UserInfo item = userInfoService.detail(id);
				model.addAttribute("userInfo", item);
			}
			
			Product product = null;
			String filename = null;
			
			product = productService.detail(no);
			filename = product.getUrl();
			if (filename != null && !filename.trim().isEmpty()) {
				filename = URLDecoder.decode(filename, "UTF-8");
			}
			
			model.addAttribute("item", product);
			model.addAttribute("filename", filename);
			
			return "product-detail";
		}
		
		// 글 작성 화면
		@RequestMapping(value = "/product-new.do", method = RequestMethod.GET)
		public String newNotice(Model model) {
			
			UserInfo item = null;
			
			String id = this.getPrincipal();
			item = userInfoService.detail(id);
			
			model.addAttribute("item", item);
			
			return "product-new";
		}
		
		// 글 작성 후, 글 목록 화면으로 이동
		@RequestMapping(value = "/product-new.do", method = RequestMethod.POST)
		public String newNotice(HttpServletRequest request,
				Integer no,
				String title,
				String name,
				Integer price,
				String content,
				Integer cid,
				@RequestParam("url") MultipartFile url)
						throws CommonException, Exception {
			
			Product product = new Product();
			product.setUser_num(no);
			product.setTitle(title);
			product.setName(name);
			product.setPrice(price);
			product.setContent(content);
			product.setCid(cid);
			
			// 최상위 경로 밑에 upload 폴더의 경로를 가져온다.
			String path = request.getServletContext().getRealPath(UPLOAD_FOLDER);
			
			// MultipartFile 객체에서 파일명을 가져온다.
			String originalName = url.getOriginalFilename();
			
			// upload 폴더가 없다면, upload 폴더 생성
			File directory = new File(path);
			if (!directory.exists()) {
				directory.mkdirs();
			}
			
			// url 객체를 이용하여, 파일을 서버에 전송
			if (url != null && !url.isEmpty()) {
				int idx = originalName.lastIndexOf(".");
				String fname = originalName.substring(0, idx);
				String ext = originalName.substring(idx, originalName.length());
				String uploadFilename = fname
						+ Long.toHexString(System.currentTimeMillis())
						+ ext;
				url.transferTo(new File(path, uploadFilename));
				uploadFilename = URLEncoder.encode(uploadFilename, "UTF-8");
				product.setUrl(uploadFilename);
			}
			
			productService.newProduct(product);
			
			return "redirect:product.do";
		}
		
		// 글 삭제 화면 확인
		@RequestMapping(value = "/product-remove.do", method = RequestMethod.GET)
		public String removeConfirm(Model model,
				@RequestParam(value = "no", required = true) String no) {
			
			model.addAttribute("no", no);
			
			return "product-remove";
		}
		
		// 글 삭제 후, 글 목록 화면으로 이동
		@RequestMapping(value = "/product-remove.do", method = RequestMethod.POST)
		public String remove(HttpServletRequest request,
				@RequestParam(value = "no", required = true) String no,
				String password)
						throws CommonException, UnsupportedEncodingException {
			
			boolean isMatched = userInfoService.isProductMatched(Integer.parseInt(no), password);
			if (!isMatched) {
				return "redirect:/product/product-remove.do?no=" + no + "&action=error-password";
			}
			
			String filename = productService.remove(no);
			if (filename != null && !filename.trim().isEmpty()) {
				fileService.remove(request, UPLOAD_FOLDER, filename);
			}
			
			productService.remove(no);
			
			return "redirect:/product.do";
		}
		
		// 글 수정하기 화면
		@RequestMapping(value = "/product-modify.do", method = RequestMethod.GET)
		public String modify(Model model,
				@RequestParam(value = "no", required = true) String no)
						throws CommonException {
			
			UserInfo item = null;
			
			String id = this.getPrincipal();
			item = userInfoService.detail(id);
			
			model.addAttribute("item", item);
			
			Product product = null;
			
			product = productService.detail(no);
			
			model.addAttribute("product", product);
			
			return "product-modify";
		}
		
		// 글 수정 후, 글 목록 화면으로 이동
		@RequestMapping(value = "/product-modify.do", method = RequestMethod.POST)
		public String modify(HttpServletRequest request,
				int no,
				String title,
				String name,
				Integer price,
				String content,
				Integer cid,
				@RequestParam("url") MultipartFile url,
				String password)
						throws CommonException, Exception {
			
			// 비밀번호를 비교해서 같지 않다면 오류메시지 출력
			boolean isMatched = userInfoService.isProductMatched(no, password);
			if (!isMatched) {
				return "redirect:/product/product-modify.do?no=" + no + "&action=error-password";
			}
			
			Product product = new Product();
			product.setNo(no);
			product.setTitle(title);
			product.setName(name);
			product.setPrice(price);
			product.setContent(content);
			product.setCid(cid);
			
			String path = request.getServletContext().getRealPath(UPLOAD_FOLDER);
			String originalName = url.getOriginalFilename();
			
			// url 객체를 이용하여, 파일을 서버에 전송
			if (url != null && !url.isEmpty()) {
				int idx = originalName.lastIndexOf(".");
				String fname = originalName.substring(0, idx);
				String ext = originalName.substring(idx, originalName.length());
				String uploadFilename = fname
						+ Long.toHexString(System.currentTimeMillis())
						+ ext;
				url.transferTo(new File(path, uploadFilename));
				uploadFilename = URLEncoder.encode(uploadFilename, "UTF-8");
				product.setUrl(uploadFilename);
			}
			
			String oldFilename = productService.modify(product);
			if (oldFilename != null && !oldFilename.trim().isEmpty()) {
				fileService.remove(request, UPLOAD_FOLDER, oldFilename);
			}
			
			productService.modify(product);
			
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
		
		// 현재 접속한 사용자의 nickname 리턴
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
