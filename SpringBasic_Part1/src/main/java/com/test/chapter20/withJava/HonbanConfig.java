package com.test.chapter20.withJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("honban")
public class HonbanConfig {
	
	@Bean
	public ProfileExWithJava profileEx(){
		ProfileExWithJava prof = new ProfileExWithJava();
		prof.setIp("201.168.172.200");
		prof.setPort("80");
		
		return prof;
	}
}
