package com.arnab.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPAspect {
	
	@Pointcut("execution(* com.arnab.spring.aop.*.*(..))")
	private void pointCut_BeforeAdvice() {
	}
	
	@Pointcut("execution(* com.arnab.spring.aop.*.printMe*())")
	private void pointCut_BeforeAdvice_BeforeTwoPRINTMEMethods() {
	}
	
	@Before("pointCut_BeforeAdvice()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("===============================================================================");
		System.out.println("Before every method, Greetings!");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method Signature: " + methodSignature);
		Object[] args = joinPoint.getArgs();
		for(Object object: args) {
			System.out.println("Method Argument: " + object);
		}
		System.out.println("===============================================================================");
	}

	@Before("execution(public void print())")
	public void beforeAdvice_beforeOnePRINTMethod() {
		System.out.println("Before your single print() method.");
	}
	
	@Before("pointCut_BeforeAdvice_BeforeTwoPRINTMEMethods()")
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
