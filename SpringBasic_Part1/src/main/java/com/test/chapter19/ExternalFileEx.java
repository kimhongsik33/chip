package com.test.chapter19;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ExternalFileEx implements InitializingBean, DisposableBean {
	
	private String envId;
	private String envPwd;
	private String extId;
	private String extPwd;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy()");
	}

	public String getEnvId() {
		return envId;
	}
	public void setEnvId(String envId) {
		this.envId = envId;
	}

	public String getEnvPwd() {
		return envPwd;
	}
	public void setEnvPwd(String envPwd) {
		this.envPwd = envPwd;
	}

	public String getExtId() {
		return extId;
	}
	public void setExtId(String extId) {
		this.extId = extId;
	}

	public String getExtPwd() {
		return extPwd;
	}
	public void setExtPwd(String extPwd) {
		this.extPwd = extPwd;
	}

}
