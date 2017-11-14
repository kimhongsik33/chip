package com.test.chapter20.withJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Bean
	public ProfileExWithJava profileEx(){
		ProfileExWithJava prof = new ProfileExWithJava();
		prof.setIp("localhost");
		prof.setPort("9090");
		
		return prof;
	}
	
}
