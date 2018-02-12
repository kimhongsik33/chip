package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoggerController {
	private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);
	
	@RequestMapping("action1")
	public void action1(){
		logger.info("action1 call!");
	}
	
	@RequestMapping("action2")
	public void action2(){
		logger.info("action2 call!");
	}
}
