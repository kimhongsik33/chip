package test.com.ex;

import java.util.ArrayList;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Player implements InitializingBean, DisposableBean {
	private String name;
	private int age;
	
	public Player(){}
	
	public Player(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Before the create Bean");		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Before the destroy Bean");
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}