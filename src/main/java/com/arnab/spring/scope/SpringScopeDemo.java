/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringScopeDemo {
	
	public SpringScopeDemo() {
		super();
		System.out.println("Constructor is called.");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Inside init() method.");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Inside destroy() method.");
	}
	
}
