package com.jarry.buz;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class DoSomething {

	public String[] doSomething(String doType) {
		if(doType == null) {
			throw new RuntimeException("��������Ϊ�ա���������");
		}
		System.out.println(this.getClass().getSimpleName() + " === " + doType);
		return (String[])Arrays.asList("a","b","c").toArray() ;
	}
}
