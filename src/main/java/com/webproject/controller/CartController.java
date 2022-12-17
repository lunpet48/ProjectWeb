package com.webproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webproject.entity.Cart;
import com.webproject.entity.CartItem;
import com.webproject.entity.Product;
import com.webproject.entity.User;
import com.webproject.service.CartItemService;
import com.webproject.service.CartService;
import com.webproject.service.ProductService;
import com.webproject.service.StorageService;
import com.webproject.service.StoreService;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartItemService cartitemService;

	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public String cartPage(ModelMap model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Long> cartId = cartService.getAllCartIdOfUser(user.get_id());
		List<List<CartItem>> cartItem = new ArrayList<>();
		cartId.forEach((n) -> cartItem.add(cartitemService.findCartItemByCartId(n)));
		
		model.addAttribute("cartItem", cartItem);
		model.addAttribute("page", "cart");
		return "web/Cart";
	}
	//dùng để gọi từ ajax
	@PostMapping("add-to-cart")
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
}
