package com.test.chapter26;

public class Student {
	private String name;
	private String studentId;
	private String age;
	private String grade;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void getInfo(){
		System.out.println("Student Name : " + getName());
		System.out.println("Student Id   : " + getStudentId());
		System.out.println("Student Age  : " + getAge());
		System.out.println("Student Grade: " + getGrade());
		
		System.out.println(10/0);
	}
}
