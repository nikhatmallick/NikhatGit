package com.bharath.spring.springcoreniki.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/bharath/spring/springcoreniki/constructorinjection/config.xml");
		Employee emp = (Employee) context.getBean("employee");
		System.out.println(emp);

	}

}
