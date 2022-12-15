package com.webproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webproject.entity.User;

@Controller
@RequestMapping("")
public class WebController {
	@GetMapping("")
	public String homePage(ModelMap model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.err.println(user);
		return "web/trangchu";
	}
}
