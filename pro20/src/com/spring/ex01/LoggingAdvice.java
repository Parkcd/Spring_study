package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable{
		System.out.println("[메소드 호출 전 : LoggingAdvice]");
		System.out.println(invocation.getMethod() + "메소드 호출 전");
		
		Object object = invocation.proceed(); // 실행 전 후로 결과를 알아서 출력해줌 그래서 Calculator 들어가서 일일이 syso 안해줘도 됨.
		
		System.out.println("[메소드 호출 후 : LoggingAdvice]");
		System.out.println(invocation.getMethod() + "메소드 호출 후");
		return object;
	}
	
}
