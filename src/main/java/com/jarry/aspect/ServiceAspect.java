package com.jarry.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面类
 */
@Aspect//定义为切面
//@Component
public class ServiceAspect {
	
	//定义切面表达式
	@Pointcut("execution(public String[] com.jarry.buz.DoSomething.*(..))")
	public void pointCut() {} ;
	
	//前置通知   通过jp可以获取参数和方法信息
	@Before(value = "pointCut()")
	public void before(JoinPoint jp) {
		System.out.println("before ........ " + jp.getSignature() + " == " + Arrays.asList(jp.getArgs()));
	}
	
	@After("pointCut()")
	public void after() {
		System.out.println("after ........ ");
	}
	
	//返回通知  通过jp可以获取参数及方法信息  通过result可以获取返回值信息  但是jp必须放在第一个参数
	@AfterReturning(value = "pointCut()" , returning = "result")
	public void returning(JoinPoint jp ,Object result) {
		System.out.println("returning ........ result = " + result);
	}
	
	@AfterThrowing(value = "pointCut()",throwing = "ex")
	public void throwing(Exception ex) {
		System.out.println("throwing ........ ex = " + ex);
	}
	
	
	
	

}
