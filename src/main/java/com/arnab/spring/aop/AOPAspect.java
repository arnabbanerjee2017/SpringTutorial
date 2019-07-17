package com.arnab.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPAspect {
	
	@Before("execution(* com.arnab.spring.aop.*.*())")
	public void beforeAdvice() {
		System.out.println("Before every method, Greetings!");
	}

	@Before("execution(public void print())")
	public void beforeAdvice_beforeOnePRINTMethod() {
		System.out.println("Before your single print() method.");
	}
	
	@Before("execution(* com.arnab.spring.aop.*.printMe*())")
	public void beforeAdvice_beforeTwoPRINTMEMethods() {
		System.out.println("Before your printMe() and printMeAgain() methods.");
	}
	
	@Before("execution(* com.arnab.spring.aop.*.printAnother*())")
	public void beforeAdvice_beforeTwoPRINTANOTHERMethods() {
		System.out.println("Before your printAnotherMe() and printAnotherMeAgain() methods.");
	}
	
	@Before("execution(* com.arnab.spring.aop.AOPTest.printTotallyNewMe())")
	public void beforeAdvice_beforeOnePRINTTOTALLYNEWMEMethod() {
		System.out.println("Before your printTotallyNewMe() method.");
	}
	
}
