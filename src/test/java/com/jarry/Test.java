package com.jarry;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jarry.config.SpringConfig;
import com.jarry.service.StudentService;

public class Test {
	
	
	@org.junit.Test
	public void test() {
//		指定profile可以通过运行参数，或者使用下面的形式，通过默认构造器创建上下文对象  再指定profile信息，最后调用register及refresh方法
//		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
//		ac.getEnvironment().setActiveProfiles("dev","test");
//		ac.register(SpringConfig.class);
//		ac.refresh();
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		String[] names = ac.getBeanDefinitionNames() ;
		for (String name : names) {
			System.out.println("bean === " + name);
		}
		
		System.out.println("===============");
		StudentService studentService = ac.getBean(StudentService.class);
//		System.out.println(studentDao.selectCount());
		studentService.insert(UUID.randomUUID().toString());
//		
//		DoSomething ds = ac.getBean(DoSomething.class);
//		ds.doSomething(null);
	}

}
