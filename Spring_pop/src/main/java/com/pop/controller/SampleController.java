package com.pop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pop.model.SampleModel;

@Controller
public class SampleController {
	
	private static final Logger logger = 
	LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public String doA() {
		logger.info("doA called........");
		return "index";
	}
	@RequestMapping("ex01")
	public String ex01(SampleModel sm) {
		
		logger.info(""+sm.getName());
		logger.info(""+sm.getAge());
		return "ex01";
	}
	@RequestMapping("ex02")
	public String ex02(SampleModel sm, Model model) {
		logger.info(""+sm.getName());
		logger.info(""+sm.getAge());
		
		model.addAttribute("id", "aaa");
		model.addAttribute("eamil", "aaa@naver.com");
		return "ex02";
	}
	@RequestMapping("ex03")
	public String ex03(RedirectAttributes rttr) {
		logger.info("aaaa");
		rttr.addFlashAttribute("msg", "hello");
		
		//return "ex04";	// forward방식으로 ex04.jsp로 이동
		return "redirect:ex04";	// redirect방식으로 ex04.jsp로 이동
	}
	@RequestMapping("ex04")
	public void ex04(String msg) {
		logger.info("zzzz");
	}
	@RequestMapping("ex05")
	public @ResponseBody SampleModel ex05() {
		SampleModel sm = new SampleModel();
		
		sm.setName("green");
		sm.setAge(10);
		
		return sm;
	}
}























