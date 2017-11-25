package com.test.chapter25;

import org.aspectj.lang.ProceedingJoinPoint;

//대상 메소드를 실행 할수 있는 기능을 가진  ProceedingJoinPoint를 전달 받는다.
//ProcedingJoinPoint는 around advice일 때 사용한다.
public class TimeCheckAdvice {
	public Object check(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("----------Start the Method----------");
		
		//proceed()를 호출하지 않으면 비지니스 로직을 수행 할 수 없다.
		Object returnValue = joinPoint.proceed();
		System.out.println("----------End the Method----------");
		
		//대상 메소드의 실행 결과 얻어진 결과Object를 반환해야 한다.
		return returnValue;
	}
}
