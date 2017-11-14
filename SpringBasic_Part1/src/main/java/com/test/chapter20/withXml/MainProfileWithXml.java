package com.test.chapter20.withXml;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainProfileWithXml {
	
	public static void main(String[] args) {
		String profile = null;
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		if(str.equals("dev")){
			profile = "dev";
		}else{
			profile = "honban";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(profile); //설정파일을 결정
		ctx.load("dev.xml", "honban.xml");
		
		ProfileExWithXml prof = ctx.getBean("profileEx", ProfileExWithXml.class);
		System.out.println("ip : " + prof.getIp());
		System.out.println("port : " + prof.getPort());
		
		ctx.close();
	}
}
