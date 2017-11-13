package com.test.chapter17;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EnvironmentEx implements EnvironmentAware, InitializingBean, DisposableBean{
	
	private Environment environment;
	private String id;
	private String pwd;
	
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("setEnvironment()");
		this.environment = environment;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		setId(environment.getProperty("environment.id"));
		setPwd(environment.getProperty("environment.pwd"));
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy()");
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
