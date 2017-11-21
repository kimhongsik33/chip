package com.test.chapter23;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceLog {
	
	//ProceedingJoinPoint객체는 원래 실행되어야 할 메서드(핵심 기능)
	public Object profile(ProceedingJoinPoint joinPoint) throws Throwable{
		String signStr = joinPoint.getSignature().toShortString();
		System.out.println(signStr + " is start!");
		
		long startTime = System.currentTimeMillis();
		try{
			Object obj = joinPoint.proceed();
			return obj;
		}finally{
			long endTime = System.currentTimeMillis();
			System.out.println(signStr + " is finished");
			System.out.println("passed time : " + (endTime - startTime));
		}
	}
}
