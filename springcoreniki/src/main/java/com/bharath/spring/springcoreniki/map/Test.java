package com.bharath.spring.springcoreniki.map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bharath/spring/springcoreniki/map/mapconfig.xml");
		Customer cust = (Customer) context.getBean("customer");
		System.out.println(cust);
		

	}

}
