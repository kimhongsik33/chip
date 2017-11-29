package com.test.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/person/{personName}")
	public String getPerson(@PathVariable String personName, Model model) throws UnsupportedEncodingException{
		
		//Non-English character input processing 
		//First Decode Value  : encoded as ISO-8859-1 
		//Second Decode Value : encoded as UTF-8
		URLDecoder.decode(URLDecoder.decode(personName, "8859_1"), "UTF-8");
		
		model.addAttribute("personInfo", personName);
		return "chapter7/personInfo";
	}
	
	@RequestMapping("/page/{var}")
	public String page(@PathVariable String var){
		String viewName = "";
		if(var.equals("one")){
			viewName = "chapter8/page1";
		}else if(var.equals("two")){
			viewName = "chapter8/page2";
		}
		
		return viewName;
	}
	
	@RequestMapping("/requestByPath/{key1}/{key2}/{key3}")
	public void requestByPath(
			@PathVariable String key1,
			@PathVariable String key2,
			@PathVariable String key3){
		System.out.println(key1);
		System.out.println(key2);
		System.out.println(key3);
		
	}
	
}
