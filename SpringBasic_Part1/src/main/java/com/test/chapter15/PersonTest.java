package com.test.chapter15;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonTest {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:person.xml");
		
		Person person1 = ctx.getBean("person", Person.class);
		System.out.println(person1.getName());
		System.out.println(person1.getAge());
		System.out.println("person1 object : " + person1);

		System.out.println("-----------------------------");
		
		Person person2 = ctx.getBean("person", Person.class);
		System.out.println(person2.getName());
		System.out.println(person2.getAge());
		System.out.println("person2 object : " + person2);
		
		if(person1.equals(person2)){
			System.out.println("person1 == person2");
		}else{
			System.out.println("person1 != person2");
		}
		
		ctx.close();
	}

}
