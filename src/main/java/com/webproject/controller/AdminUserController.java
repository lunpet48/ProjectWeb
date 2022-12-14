package com.webproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webproject.service.UserService;
import com.webproject.service.impl.UserServiceImpl;
import com.webproject.entity.*;
@Controller
@RequestMapping("admin/user")
public class AdminUserController {
	@Autowired
	UserService userService;
	
	@GetMapping("all")
	public String User(ModelMap modelMap){
		List<User>users=userService.findAll();
		modelMap.addAttribute("listuser", users);
		return "admin/Table/user";
	}
	
	@GetMapping("chart")
	public String chart(ModelMap modelMap) {
		List<com.webproject.entity.User>users=userService.newUsers();
		modelMap.addAttribute("listuser", users);
		return "admin/chart/chart_user";
	}
}
