package test.com.ex;

import javax.annotation.*;

public class Player2{
	private String name;
	private int age;
	
	public Player2(){}
	
	public Player2(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Before the create Bean2!");
		System.out.println("Before the create Bean2!_hotfix");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Before the destory Bean2");
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