package com.test.mvc.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.test.mvc.service.Shoes;

public class UserShoes {
	@Autowired
	@Qualifier("shoesImpl02")
	Shoes shoes;
	
//	public Shoes getShoes(){
//		return shoes;
//	}
//	
//	public void setShoes(Shoes shoes){
//		this.shoes = shoes;
//	}
	
	public String getShoesBrand(){
		return "Selected Shoes : " + shoes.getBrand(); 
	}
}
