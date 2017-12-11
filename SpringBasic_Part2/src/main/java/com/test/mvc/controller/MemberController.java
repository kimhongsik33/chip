package com.test.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.mvc.dto.Member;
import com.test.mvc.validation.MemberValidator;

@Controller
public class MemberController {
	@RequestMapping("/memberForm")
	public String memberForm(){
		return "chapter15/memberJoin";
	}
	
	@RequestMapping("/joinOk")
	public String joinOk(@ModelAttribute("model") @Valid Member member, BindingResult result){
		String pageName = "chapter15/memberOK";
		
//		MemberValidator memberValidator = new MemberValidator();
//		memberValidator.validate(member, result);
		
		if(result.hasErrors()){
			pageName = "chapter15/memberJoin";
		}
		
		return pageName;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new MemberValidator());
	}
}
