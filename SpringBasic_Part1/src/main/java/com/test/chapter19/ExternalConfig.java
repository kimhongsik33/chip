package com.test.chapter19;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ExternalConfig {
	
	@Value("${environment.id}")
	private String envId;
	
	@Value("${environment.pwd}")
	private String envPwd;
	
	@Value("${external.id}")
	private String extId;
	
	@Value("${external.pwd}")
	private String extPwd;
	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties(){
		//프로퍼티 파일의 위치값을 저장하는 객체
		//com.test.chapter18 external.xml <context:property-placeholder>와 동일한 역할
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("environment.properties");
		locations[1] = new ClassPathResource("external.properties");
		
		configurer.setLocations(locations);
		
		return configurer;
	}
	
	@Bean
	public ExternalFileEx externalConfigMethod(){
		ExternalFileEx external = new ExternalFileEx();
		external.setEnvId(envId);
		external.setEnvPwd(envPwd);
		external.setExtId(extId);
		external.setExtPwd(extPwd);
		
		return external;
	}
}
