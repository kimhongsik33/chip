package com.test.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.mvc.dto.Chapter22MemberInfo;

@Controller
public class Chapter22MemberController {
	
	@RequestMapping("ch22AddMember")
	public String addMember(@ModelAttribute Chapter22MemberInfo ch22MemberInfo, BindingResult result){
		
		System.out.println("Name : " + ch22MemberInfo.getName());
		System.out.println("ID : " + ch22MemberInfo.getId());
		
		return "redirect:/ch22MemberInput";
		
	}
	
	@RequestMapping("/ch22MemberInput")
	public ModelAndView showMemberInfo(){
		// view/chapter22/memberInfo의 뷰이름에 command객체 라고 이름을 붙인 new Chapter22MemberInfo()객체를 전달한다. 
		return new ModelAndView("chapter22/memberInfo",  "command", new Chapter22MemberInfo());
	}

}
