package com.vking.aop;

import org.aspectj.lang.JoinPoint;

public class DataRepositoryAspect {
	public void after(JoinPoint joinPoint){
		System.out.println("afer method");
	}
	
	
	public void before(JoinPoint joinPoint){
		System.out.println("before method");
	}
	
    public void afterReturn(JoinPoint joinPoint, Object returning) {
    	System.out.println("after return method");
    }

    public void afterThrowing(JoinPoint joinPoint, Exception throwing) {
    	System.out.println("after throwing");
    }

}
