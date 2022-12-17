package com.webproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webproject.entity.CartItem;
import com.webproject.entity.Order;
import com.webproject.entity.OrderItem;
import com.webproject.entity.User;
import com.webproject.model.OrderModel;
import com.webproject.service.CartItemService;
import com.webproject.service.OrderItemService;
import com.webproject.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	

	@Autowired
	private CartItemService cartItemService;
	
	@PostMapping("add")
	public ModelAndView login(ModelMap model,  @Valid @ModelAttribute("cartitem") List<Long> cartItem,@Valid @ModelAttribute("order") OrderModel order, BindingResult result, HttpSession session) throws JSONException
	{	
		User user = (User) session.getAttribute("user");
		
		
		List<CartItem> cartItems = new ArrayList<>(); 
		cartItem.forEach((n) -> cartItems.add(cartItemService.findById(n).get()));
		
		while(!cartItems.isEmpty()) {
			CartItem entity = cartItems.get(0);
			
			Order orderEntity =  new Order();
			orderEntity.setUserId(user);
			BeanUtils.copyProperties(order, orderEntity);
			orderEntity.setStoreId(entity.getCartId().getStoreId());
			orderService.save(orderEntity);
			
			List<CartItem> removeList = new ArrayList<>();
			for (CartItem cartItemEntity : cartItems) {
				if(cartItemEntity.getCartId().getStoreId() == orderEntity.getStoreId()) {
					OrderItem orderItemEntity = new OrderItem();
					orderItemEntity.setOrderId(orderEntity);
					orderItemEntity.setProductId(cartItemEntity.getProductId());
					orderItemEntity.setCount(cartItemEntity.getCount());
					orderItemService.save(orderItemEntity);
					//cartItems.remove(cartItemEntity);
					removeList.add(cartItemEntity);
				}
			}
			
			//remove
			for (CartItem cartItemRemove : removeList) {
				cartItems.remove(cartItemRemove);
			}
			
			
		}
		
		return new ModelAndView("redirect:/cart");
	}
}
