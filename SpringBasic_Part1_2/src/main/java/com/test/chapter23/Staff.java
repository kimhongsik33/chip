package com.test.chapter23;

public class Staff {
	private String name;
	private int age;
	private String dept;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void getInfo(){
		System.out.println("Name : " + getName());
		System.out.println("Age  : " + getAge());
		System.out.println("Dept : " + getDept());
	}
}
