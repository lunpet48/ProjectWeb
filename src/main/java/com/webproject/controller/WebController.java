package com.webproject.controller;

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
	@GetMapping("cart")
	public String cartPage(ModelMap model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("page", "cart");
		return "web/Cart";
	}
	//dùng để gọi từ ajax
	@PostMapping("cart/add-to-cart")
	public ResponseEntity<?>  addToCart(@Valid @RequestBody Long pid, HttpSession session) throws Exception {
		Cart cart;
		CartItem cartItem;
		User user = (User) session.getAttribute("user");
		System.err.println(user);
		Product product = productService.findById(pid).get();
		
		Optional<Cart> opt = cartService.findCartByUserIdAndStoreId(user.get_id(), product.getStoreId().get_id());
		if(opt.isEmpty()) {
			System.err.println("empty");
			cart = new Cart();
			cart.setUserId(user);
			cart.setStoreId(product.getStoreId());
			cartService.save(cart);
		}
		else {
			System.err.println("present");
			cart = opt.get();
		}
		
		Optional<CartItem> cartItemOpt = cartitemService.findCartItemByCartIdAndProductId(cart.get_id(), product.get_id());
		if(cartItemOpt.isEmpty()) {
			System.err.println("empty");
			cartItem= new CartItem();
			cartItem.setCartId(cart);
			cartItem.setCount(1);
			cartItem.setProductId(product);
			cartitemService.save(cartItem);
		}
		else {
			System.err.println("present");
			cartItem = cartItemOpt.get();
			cartItem.setCount(cartItem.getCount() + 1);
			cartitemService.save(cartItem);			
		}
		
		return ResponseEntity.ok("thanhf coong");

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
