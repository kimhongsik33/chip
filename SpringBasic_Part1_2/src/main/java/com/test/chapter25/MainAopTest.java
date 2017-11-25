package com.test.chapter25;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainAopTest {

	public static void main(String[] args) {
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/resources/aopEx02.xml");
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopEx02.xml");
		
		Service service = ctx.getBean("service", ServiceImpl.class);
		service.addBoard();
		
		ctx.close();
		

	}

}
