package com.test.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	/*
	 * redirect : 키를 이용한 페이지 이동
	 * **/
	@RequestMapping("/loginForm")
	public String loginForm(){
		return "chapter13/loginId";
	}
	
	
	@RequestMapping("/memberConfirm")
	public String memberRedirect(HttpServletRequest request, Model model){
		String id = request.getParameter("id");
		
		if(id.equals("test")){
			return "redirect:memberOK";
		}
		
		return "redirect:memberFail";
	}
	
	@RequestMapping("/memberOK")
	public String memberOK(){
		return "chapter13/memberOK";
	}
	
	@RequestMapping("/memberFail")
	public String memberFail(){
		return "chapter13/memberFail";
	}
	
}
