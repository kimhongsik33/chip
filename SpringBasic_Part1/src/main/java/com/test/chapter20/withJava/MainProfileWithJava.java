package com.test.chapter20.withJava;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.chapter20.withXml.ProfileExWithXml;

public class MainProfileWithJava {

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
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(profile); //설정파일을 결정
		ctx.register(DevConfig.class, HonbanConfig.class);
		ctx.refresh();
		
		ProfileExWithJava prof = ctx.getBean("profileEx", ProfileExWithJava.class);
		System.out.println("ip : " + prof.getIp());
		System.out.println("port : " + prof.getPort());
		
		ctx.close();

	}

}
