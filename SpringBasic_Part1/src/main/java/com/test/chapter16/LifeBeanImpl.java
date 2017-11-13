package com.test.chapter16;

import org.springframework.beans.factory.BeanNameAware;

public class LifeBeanImpl implements LifeBean, BeanNameAware {
	
	private String beanName; // 설정파일에서 bean의 id를 저장하기 위한 변수
	
	public void init(){
		System.out.println("사용자 초기화 메서드");
	}
	
	public void end(){
		System.out.println("사용자 소멸 메소드");
	}

	@Override
	public void lifeMethod() {
		System.out.println("비지니스 로직을 수행합니다.");
		System.out.println(beanName);
	}
	
	//빈 객체가 자기자신의 이름을 알아야 할 경우 사용되는 메소드 (객체가 생성될 때 해당 객체의 id값을 전달 받는 메소드)
	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
}
