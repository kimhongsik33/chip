package com.test.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostGetController {
	
	@RequestMapping("/input")
	public String goInputForm(){
		
		return "/chapter9/inputForm";
	}
	
	@RequestMapping(value="/person", method=RequestMethod.GET)
	public String goOutputForm(HttpServletRequest request, Model model){
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		
		return "chapter9/outputForm";
	}
	
	@RequestMapping(value="/person", method=RequestMethod.POST)
	public ModelAndView goOutputForm(HttpServletRequest request){
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("chapter9/outputForm");
		mav.addObject("name", name);
		mav.addObject("id", id);
		
		return mav;
	}
}
