package com.test.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.test.mvc.dto.UserShoes;

public class UserShoesTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/resources/shoes.xml");
		UserShoes userShoes = (UserShoes)ctx.getBean("userShoes");
		System.out.println(userShoes.getShoesBrand());
	}

}
