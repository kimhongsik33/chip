package com.test.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
