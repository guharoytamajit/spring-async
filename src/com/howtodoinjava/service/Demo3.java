package com.howtodoinjava.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

public class Demo3 {
	@Async
	public Future<String> doSomething() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return new AsyncResult<String>("resopnse from demo3");
	}

}
