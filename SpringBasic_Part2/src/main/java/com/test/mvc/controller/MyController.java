package com.test.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/memberInput")
	public String memberInput(){
	
		return "memberRegister";
	}
	
	@RequestMapping("/post/memberInfo")
	public String memeberInfo(Model model){
		model.addAttribute("name", "KIM");
		
		return "post/memberInfo";
	}
	
	@RequestMapping("/modelAndView/mv")
	public ModelAndView modelAndView(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("email", "aaaa@google.com");
		mv.setViewName("modelAndView/modelView");
		
		return mv;
	}
}
