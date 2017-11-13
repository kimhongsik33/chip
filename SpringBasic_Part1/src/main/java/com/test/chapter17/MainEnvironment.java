package com.test.chapter17;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainEnvironment {

	public static void main(String[] args) throws IOException{
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment environment = ctx.getEnvironment();
		MutablePropertySources propertySources = environment.getPropertySources();
		
		propertySources.addLast(new ResourcePropertySource("classpath:environment.properties"));
		
		//from [environment.properties]
		System.out.println("first : " + environment.getProperty("environment.id"));
		System.out.println("first : " + environment.getProperty("environment.pwd"));

		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		
		//bean생성
		gCtx.load("environment.xml");
		gCtx.refresh();
		
		EnvironmentEx envEx = gCtx.getBean("environment", EnvironmentEx.class);
		System.out.println(envEx.getId());
		System.out.println(envEx.getPwd());
		
		gCtx.close();
		ctx.close();
	}

}
