package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice어노테이션은 현재 이클립스가 컨트롤러에서 발생하는 Exception을 전문적으로 처리하는 클래스임을 알려준다.
@ControllerAdvice
public class CommonExceptionAdvice {
	private static final Logger logger = 
			LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	/*@ExceptionHandler(Exception.class)
	public String common(Exception e){
		logger.info(e.toString());
		
		return "err_exception";
	}*/
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception e){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/err_exception");
		mav.addObject("exception", e);
		
		return mav;
	}
	
}
