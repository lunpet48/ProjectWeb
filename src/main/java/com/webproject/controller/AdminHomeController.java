package com.webproject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webproject.entity.Order;
import com.webproject.entity.User;
import com.webproject.service.OrderItemService;
import com.webproject.service.OrderService;
import com.webproject.service.ProductService;
import com.webproject.service.StoreService;
import com.webproject.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminHomeController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserService userService;
	
	@Autowired
	StoreService storeService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService orderItemService;
	
	
	@GetMapping("")
	public String Home(ModelMap modelMap){
		User user = (User) session.getAttribute("user");
		if (user == null)
			return "redirect:/account/login";
		//count
		Long countUser=userService.Count();
		Long countStore=storeService.count();
		Long countProduct=productService.count();
		Long orderCount=orderService.count();
		modelMap.addAttribute("countUser", countUser);
		modelMap.addAttribute("countStore", countStore);
		modelMap.addAttribute("countProduct", countProduct);
		modelMap.addAttribute("orderCount", orderCount);
		
		//Revenue
		double revenueTotat=0;
		List<Order>orders=orderService.findAll();
		for (Order order : orders) {
			revenueTotat=revenueTotat+order.getAmountFromUser();
		}
		
		
		
		//Product
		
		//Order
		
		
		
		//User
		
		return "admin/home";
	}
}
