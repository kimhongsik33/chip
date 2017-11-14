package com.test.chapter19;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainExternalToJava {
	
	public static void main(String[] args){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ExternalConfig.class);
		ExternalFileEx external = ctx.getBean("externalConfigMethod", ExternalFileEx.class);
		
		System.out.println("envId : " + external.getEnvId());
		System.out.println("envPwd : " + external.getEnvPwd());
		System.out.println("extId : " + external.getExtId());
		System.out.println("extPwd : " + external.getExtPwd());
		
		ctx.close();
	}
	
}
