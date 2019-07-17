package com.arnab.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPAspect {

	@Before("execution(public void print())")
	public void beforeAdvice() {
		System.out.println("Before your business logic.");
	}
	
}
