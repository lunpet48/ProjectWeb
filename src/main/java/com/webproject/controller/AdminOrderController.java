package com.webproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webproject.entity.Order;
import com.webproject.entity.OrderItem;
import com.webproject.service.OrderItemService;
import com.webproject.service.OrderService;
import com.webproject.service.ProductService;

@Controller
@RequestMapping("admin/order")
public class AdminOrderController {
	@Autowired
	ProductService productService;
	@Autowired 
	OrderService orderService;
	@Autowired
	OrderItemService orderItemService;
	
	@RequestMapping("{status}/{index}")
	public String listOrder(ModelMap modelMap,@RequestParam("status") String status, @RequestParam("index") Integer index) {
		if(index==null) {
			index=1;
		}
		if(status==null) {
			status="all";
			Page<Order>page=orderService.findAll(index-1, 6);
			List<Order>orders=page.getContent();
			modelMap.addAttribute("listOrder", orders);
			modelMap.addAttribute("page",page);
		}else {
			Page<Order>page=orderService.findByStatus(status, index-1, 6);
			List<Order>orders=page.getContent();
			modelMap.addAttribute("listOrder", orders);
			modelMap.addAttribute("page",page);
		}
		
		return "admin/Table/order";
	}
	
	@GetMapping("details/{orderId}")
	public String Details(ModelMap Model,@RequestParam("orderId") Long Id) {
		List<OrderItem>orderItems=orderItemService.findByOrderId(Id);
		Model.addAttribute("listOrderItem", orderItems);
		return"admin/Table/orderItem";
	}
	
	@PostMapping("edit/{id}")
	public String edit(ModelMap modelMap, @RequestParam("id") Long id) {
		Optional<Order>optional=orderService.findById(id);
		Order order=optional.get();
		order.setStatus("Đang giao");
		
		return "redirect:/admin/order/all/1";
	}

}






