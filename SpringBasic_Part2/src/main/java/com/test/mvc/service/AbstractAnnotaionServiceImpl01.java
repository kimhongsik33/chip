package com.test.mvc.service;

import org.springframework.stereotype.Component;

@Component("service01")
public class AbstractAnnotaionServiceImpl01 implements AbstractAnnotaionService {
	private String name = "01";
	
	@Override
	public String getClassName() {
		
		return "AbstractAnnotaionServiceImpl - " + name;
	}
}
