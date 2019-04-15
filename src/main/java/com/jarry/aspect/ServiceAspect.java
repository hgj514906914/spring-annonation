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
 * ������
 */
@Aspect//����Ϊ����
//@Component
public class ServiceAspect {
	
	//����������ʽ
	@Pointcut("execution(public String[] com.jarry.buz.DoSomething.*(..))")
	public void pointCut() {} ;
	
	//ǰ��֪ͨ   ͨ��jp���Ի�ȡ�����ͷ�����Ϣ
	@Before(value = "pointCut()")
	public void before(JoinPoint jp) {
		System.out.println("before ........ " + jp.getSignature() + " == " + Arrays.asList(jp.getArgs()));
	}
	
	@After("pointCut()")
	public void after() {
		System.out.println("after ........ ");
	}
	
	//����֪ͨ  ͨ��jp���Ի�ȡ������������Ϣ  ͨ��result���Ի�ȡ����ֵ��Ϣ  ����jp������ڵ�һ������
	@AfterReturning(value = "pointCut()" , returning = "result")
	public void returning(JoinPoint jp ,Object result) {
		System.out.println("returning ........ result = " + result);
	}
	
	@AfterThrowing(value = "pointCut()",throwing = "ex")
	public void throwing(Exception ex) {
		System.out.println("throwing ........ ex = " + ex);
	}
	
	
	
	

}
