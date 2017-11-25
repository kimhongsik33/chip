package com.test.chapter27;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AdviceLog {
	
	//①②③어떤것도 쓸수 있다.
	//①　@Pointcut("within(com.test.chapter27.*)")
	//②　@Pointcut("execution(* com.test.chapter27.*.*())")
	//③　@Pointcut("bean(student)")
	@Pointcut("within(com.test.chapter27.*)")
	private void pointcutMethod(){}
	
	@Around("pointcutMethod()")
	//ProceedingJoinPoint객체는 원래 실행되어야 할 메서드(핵심 기능)
	public Object profile(ProceedingJoinPoint joinPoint) throws Throwable{
		String signStr = joinPoint.getSignature().toShortString();
		System.out.println(signStr + " is start!!");
		long startTime = System.currentTimeMillis();
		
		try{
			Object obj = joinPoint.proceed();
			return obj;
		}finally{
			long endTime = System.currentTimeMillis();
			System.out.println(signStr + " is finished!!!");
			System.out.println(signStr + " 경과 시간 : "+(endTime - startTime));		
		}
	}
	
	//①　@Before("within(com.test.chapter27.*)")
	//②　@Before("pointcutMethod()")
	@Before("within(com.test.chapter27.*)")
	//@Around처럼 pointcut메소드를 호출하는 방법으로 해도됨.
	public void beforeAdvice(JoinPoint joinPoint){
		System.out.println("beforeAdvice().....");
	}
	
	/*public void afterReturningAdvice(){
		System.out.println("afterReturningAdvice().....");
	}
	
	public void afterThrowingAdvice(){
		System.out.println("afterThrowingAdvice().....");
	}
	
	public void afterAdvice(){
		System.out.println("afterAdvice().....");
	}*/

}
