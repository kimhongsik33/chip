package com.test.chapter18;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExternal {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:external.xml");
		ExternalFileEx ext = ctx.getBean("externalFileEx", ExternalFileEx.class);
		
		System.out.println("getEnvId() : " + ext.getEnvId());
		System.out.println("getEnvPwd() : " + ext.getEnvPwd());
		System.out.println("getExtId() : " + ext.getExtId());
		System.out.println("getExtPwd() : " + ext.getExtPwd());
		
		ctx.close();
	}

}
