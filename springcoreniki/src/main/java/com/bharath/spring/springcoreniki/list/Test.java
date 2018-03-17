package com.bharath.spring.springcoreniki.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/bharath/spring/springcoreniki/list/listconfig.xml");
		Hospital hosp = (Hospital) context.getBean("hospital");
		System.out.println("Hospital Name: " + hosp.getName());
		System.out.println(hosp.getDepartments());
		System.out.println(hosp.getDepartments().getClass());
		
	}

}
