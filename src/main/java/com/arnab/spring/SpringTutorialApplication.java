package com.arnab.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.arnab.spring.aop.AOPTest;
import com.arnab.spring.scope.SpringScopeDemo;

@SpringBootApplication
public class SpringTutorialApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringTutorialApplication.class, args);
		
		// Spring Scope Demo
		/*SpringScopeDemo one = ctx.getBean(SpringScopeDemo.class);
		SpringScopeDemo two = ctx.getBean(SpringScopeDemo.class);
		System.out.println("If the two objects are same: " + (one == two));
		System.out.println("Object 1: " + one);
		System.out.println("Object 2: " + two);*/
		
		/**
		 * AOP Demo.
		 * 
		 */
		AOPTest aopTest = ctx.getBean(AOPTest.class);
		aopTest.print();
	}

}