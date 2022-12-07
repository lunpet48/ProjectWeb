package com.webproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webproject.model.StoreModel;

@Controller
@RequestMapping("")
public class HomeController {
	@GetMapping("")
	public String createStore(ModelMap model) {
		StoreModel store = new StoreModel();
		store.setIsActive(false);
		store.setIsOpen(false);
		model.addAttribute("store", store);
		return "vendor/store/createStore";
	}
}
