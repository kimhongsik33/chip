package com.test.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.mvc.dto.UserDto;

@Controller
public class UserController {
	
	
//	@ModelAttribute("hitCar")
//	public String[] refHitCar(){
//		return new String[]{"A_Car","B_Car","C_Car","D_Car"};
//	}
	
	//@RequestMapping("/userForm")이 실행되기 전에 먼저 실행 된다.
	@ModelAttribute("userDto")
	public UserDto initMethod(HttpServletRequest request){
		System.out.println("[ModelAttribute init()...]");
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			System.out.println("[GET]...");
			UserDto userDto = new UserDto();
			userDto.setAddress("input the address");
			userDto.setCar("input the car");
			userDto.setUserName("input the name");
			
			return userDto;
		} else {
			System.out.println("@ModelAttribute : POST....");
			return new UserDto();
		}
	}
	
	@RequestMapping("/userForm")
	public String userForm(){
		System.out.println("[userForm]");
		return "chapter11/userInputForm";
	}
	
	@RequestMapping(value="/userSave", method=RequestMethod.POST)
	public ModelAndView userSave(UserDto userDto, Model model){
		System.out.println("[userSave]");
		System.out.println(userDto.toString());
		
		model.addAttribute("msg", "Output Member Information");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("chapter11/userOutputForm");
		modelAndView.addObject("userDto", userDto);
		
		return modelAndView;
	}
	
//	@RequestMapping("/userView")
//	public Model userView(Model model){
//		System.out.println("[userView]");
//		//Model model = new ExtendedModelMap();
//		model.addAttribute("msg", "Car Info");
//		
//		return model;
//	}
}
