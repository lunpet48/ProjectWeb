package com.webproject.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webproject.entity.User;
import com.webproject.model.UserModel;
import com.webproject.service.UserService;

@Controller
@RequestMapping("/account/profile")
public class ProfileController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public String profilePage(ModelMap model, HttpSession session) {
		
		return "web/profile";
	}
	
	@GetMapping("/edit")
	public String profileEditPage(ModelMap model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null)
			return "redirect:/account/login";
		
		model.addAttribute("user",user);
		return "web/editProfile";
	}
	
	@PostMapping("/edit")
	public String profileEdit(ModelMap model,@Valid @ModelAttribute("user") UserModel usermodel, BindingResult result, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null)
			return "redirect:/account/login";
		user.setFirstName(usermodel.getFirstName());
		user.setLastName(usermodel.getLastName());
		user.setIdCard(usermodel.getIdCard());
		user.setPhone(usermodel.getPhone());
		user.setAddress(usermodel.getAddress());
		userService.save(user);
		
		model.addAttribute("user",user);
		return "web/editProfile";
	}
	
	@GetMapping("/change-password")
	public String changePassPage(ModelMap model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null)
			return "redirect:/account/login";
		
		model.addAttribute("user",user);
		return "web/changePassword";
	}
	@PostMapping("/change-password")
	public String changePassword(ModelMap model,@Valid @ModelAttribute("user") UserModel usermodel, BindingResult result, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String message= "";
		if(user == null)
			return "redirect:/account/login";
		
		if(BCrypt.checkpw(usermodel.getCurrentpassword(), user.getHashedPassword())) {
			if(usermodel.getPassword().equals(usermodel.getPassword2())) {
				user.setHashedPassword(BCrypt.hashpw(usermodel.getPassword(), BCrypt.gensalt()));
				userService.save(user);
				message = "Đổi mật khẩu thành công";
				model.addAttribute("messageSuccess",message);
			}
			else {
				message = "Mật khẩu nhập lại không chính xác";
				model.addAttribute("messageError",message);
			}
		}
		else {
			message = "Mật khẩu không chính xác";
			model.addAttribute("messageError",message);
		}
		
		
		
		model.addAttribute("user",user);
		return "web/changePassword";
	}
}
