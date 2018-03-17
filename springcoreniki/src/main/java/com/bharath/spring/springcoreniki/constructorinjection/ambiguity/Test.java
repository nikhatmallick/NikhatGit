package com.bharath.spring.springcoreniki.constructorinjection.ambiguity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("com/bharath/spring/springcoreniki/constructorinjection/ambiguity/config.xml");
		Addition addi = (Addition) context.getBean("addition");
		System.out.println(addi);
	}

}
