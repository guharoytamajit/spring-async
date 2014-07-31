package com.howtodoinjava.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
	
 long startTime = System.currentTimeMillis();
	
	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	Demo demo =(Demo) context.getBean("async");
	Demo2 demo2 =(Demo2) context.getBean("async2");
	Demo3 demo3 =(Demo3) context.getBean("async3");
	Future<String> futureResult = demo.doSomething(); 
	Future<String> futureResult2 = demo2.doSomething();  // spring makes this an async call
	Future<String> futureResult3 = demo3.doSomething();  // spring makes this an async call
	try{
	 // spring makes this an async call
	String result = futureResult.get(11, TimeUnit.SECONDS);
	System.out.println(result);
	}
	catch(TimeoutException e){
		System.out.println("demo timeout occured");
	}
	try{
	
	String result = futureResult2.get(11, TimeUnit.SECONDS);
	System.out.println(result);
	}
	catch(TimeoutException e){
		System.out.println("demo2 timeout occured");
	}
	try{
	
	String result = futureResult3.get(11, TimeUnit.SECONDS);
	System.out.println(result);
	}
	catch(TimeoutException e){
		System.out.println("demo3 timeout occured");
	}
	
	 long endTime = System.currentTimeMillis();
	 System.out.println((endTime-startTime)/1000+" seconds taken");
	
}
}
