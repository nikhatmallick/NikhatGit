package com.bharath.spring.springcoreniki.propertyplaceholder.assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/bharath/spring/springcoreniki/propertyplaceholder/assignment/config.xml");
		WSclient wsc = (WSclient) context.getBean("wsclient");
		System.out.println(wsc);

	}

}
