package com.test.chapter14;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:baseBall4.xml");
		ctx.refresh(); //초기화 작업
		ctx.close();

	}

}
