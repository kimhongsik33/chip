package com.test.mvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.test.mvc.service.AbstractAnnotaionService;

//@Component
@Controller
public class AbstractAnnotationController extends AbstractController {
	
	@Resource(name="service01")
	private AbstractAnnotaionService service;
	
	@Override
	@RequestMapping("/component")
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chapter19/componentView");
		mv.addObject("message", "Component Annotaion Test");
		
		System.out.println("----------------");
		System.out.println(service.getClassName());
		System.out.println("----------------");
		
		return mv;
	}
}
