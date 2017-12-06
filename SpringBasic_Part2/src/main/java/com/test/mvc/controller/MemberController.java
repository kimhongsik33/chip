package com.test.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.mvc.dto.Member;

@Controller
public class MemberController {
	@RequestMapping("/memberForm")
	public String memberForm(){
		return "chapter15/memberJoin";
	}
	
	@RequestMapping("/joinOk")
	public String joinOk(@ModelAttribute("model") Member member, BindingResult result){
		String pageName = "memberOk";
		
		return "";
	}
}
