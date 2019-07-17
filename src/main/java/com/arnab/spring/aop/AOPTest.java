package com.arnab.spring.aop;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class AOPTest {

	public void print() {
		System.out.println("IN AOP print().");
	}
	
	public void printMe() {
		System.out.println("IN AOP printMe().");
	}
	
	public void printMeAgain() {
		System.out.println("IN AOP printMeAgain().");
	}
	
	public void printAnotherMe() {
		System.out.println("IN AOP printAnotherMe().");
	}
	
	public void printAnotherMeAgain() {
		System.out.println("IN AOP printAnotherMeAgain().");
	}
	
	public void printTotallyNewMe() {
		System.out.println("IN AOP printTotallyNewMe().");
	}
	
	public void printTotallyNewMe(String value) {
		System.out.println("IN AOP printTotallyNewMe(). Value - " + value);
	}
	
	public void printTotallyNewMe(String value, Date date) {
		System.out.println("IN AOP printTotallyNewMe(). Value - " + value + ", Date: " + date);
	}
	
}
