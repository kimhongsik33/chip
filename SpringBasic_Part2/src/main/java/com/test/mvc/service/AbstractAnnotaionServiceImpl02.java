package com.test.mvc.service;

import org.springframework.stereotype.Component;

@Component("service02")
public class AbstractAnnotaionServiceImpl02 implements AbstractAnnotaionService {
	private String name = "02";
	
	@Override
	public String getClassName() {
		
		return "AbstractAnnotaionServiceImpl - " + name;
	}
}
