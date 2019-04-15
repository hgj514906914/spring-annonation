package com.jarry.buz;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class DoSomething {

	public String[] doSomething(String doType) {
		if(doType == null) {
			throw new RuntimeException("参数不能为空。。。。。");
		}
		System.out.println(this.getClass().getSimpleName() + " === " + doType);
		return (String[])Arrays.asList("a","b","c").toArray() ;
	}
}
