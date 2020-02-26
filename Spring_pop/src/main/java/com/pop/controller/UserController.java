package com.pop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pop.model.LoginVO;
import com.pop.model.UserVO;
import com.pop.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService uservice;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET() {
		
	}
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPost(LoginVO log, Model model) throws Exception {
		
		UserVO user = uservice.login(log);
		System.out.println("user="+user);
		if(user==null) {return;}
		model.addAttribute("userVO", user);
	}
}
