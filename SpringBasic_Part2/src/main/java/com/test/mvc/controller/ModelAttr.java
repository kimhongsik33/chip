package com.test.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.mvc.dto.UserInformation;

@Controller
public class ModelAttr {

	@RequestMapping("/form")
	public String userBasicController(){
		return "chapter10/userForm";
	}
	
	@RequestMapping("/userInfo")
	public String userInfoController(@ModelAttribute("userInfo") UserInformation userInformation){
		
		return "chapter10/userInfo";
	}
}
