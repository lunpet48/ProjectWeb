package com.webproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webproject.entity.Cart;
import com.webproject.entity.CartItem;
import com.webproject.entity.Product;
import com.webproject.entity.Store;
import com.webproject.entity.User;
import com.webproject.service.CartItemService;
import com.webproject.service.CartService;
import com.webproject.service.ProductService;
import com.webproject.service.StorageService;
import com.webproject.service.StoreService;

@Controller
@RequestMapping("")
public class WebController {
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartItemService cartitemService;

	@Autowired
	private StorageService storageService;

	@Autowired
	private ProductService productService;

	@GetMapping("images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serverFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	@GetMapping("")
	public String homePage(ModelMap model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Product> list = productService.findLastestProduct();
		
		model.addAttribute("page", "home");
		model.addAttribute("productlist", list);
		return "web/trangchu";
	}
	
	@GetMapping("category-list")
	public String categoryPage(ModelMap model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("page", "category");
		return "web/CategoryList";
	}
	
	@GetMapping("store/{id}")
	public String getMethodName(Model model, @PathVariable Long id) {
		Optional<Store> opt = storeService.findById(id);
		List<Product> list = productService.findAllByStoreId(opt.get().get_id());
		model.addAttribute("store", opt.get());
		model.addAttribute("listProducts", list);
		return "vendor/InfoStore";
	}

}
