package com.spring.test;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//스프링의 테스트 컨텍스트 프레임워크 JUnit 확장 기능 지정
//SpringJUnit4ClassRunner.class : spring-test에서 제공하는 단위테스트를 위한 클래스 러너
@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration //Spring MVC를 테스트 하는데 있어서 필요한 어노테이션, 기존의 스프링 테스트와는 다른점이다.
@ContextConfiguration(locations={"file:/src/main/webapp/WEB-INF/spring/**/*.xml"}) 
//spring bean 메타 설정 파일의 위치를 지정할 때 사용되는 애노테이션이며 경로를 지정하지 않으면 테스트 클래스 파일이 있는 패키지 내에서 다음의 설정 파일을 사용한다.
//ContextConfigLocationTest-context.xml
public class ControllerTest {
	public static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);
	
	@Inject
	private WebApplicationContext wepAppCtx;
	
	//브라우저에서 요청과 응답을 하는 객체를 의미. Controller테스트 사용을 용이하게 해주는 라이브러리
	//톰캣없이 단위테스트를 진행 하기 위해서는 MockMvc를 사용하여 테스트한다.
	private MockMvc mockMvc; 
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wepAppCtx).build();
		logger.info("setup() call!");
	}
	
	@Test
	public void testController() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/controller"));
	}
}
