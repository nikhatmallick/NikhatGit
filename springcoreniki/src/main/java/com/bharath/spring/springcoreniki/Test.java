package com.bharath.spring.springcoreniki;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		Employee emp = (Employee)ctx.getBean("emp");
		System.out.println("Employee id: " + emp.getId());
		System.out.println("Employee name: "+ emp.getName());

	}

}
