package com.howtodoinjava.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

public class Demo {
	@Async
	public Future<String> doSomething() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return new AsyncResult<String>("resopnse from demo");
	}

}
