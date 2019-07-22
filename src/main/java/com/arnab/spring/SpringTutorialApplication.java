/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring;

import java.util.Date;

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
		long startTime = System.currentTimeMillis();
		AOPTest aopTest = ctx.getBean(AOPTest.class);
		aopTest.print();
		aopTest.printMe();
		aopTest.printMeAgain();
		aopTest.printAnotherMe();
		aopTest.printAnotherMeAgain();
		aopTest.printTotallyNewMe();
		aopTest.printTotallyNewMe("ARNAB");
		aopTest.printTotallyNewMe("GOPAL", new Date());
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("Time taken: " + timeTaken);
	}

}
