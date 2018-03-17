package com.bharath.spring.springcoreniki.lc.innerbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bharath/spring/springcoreniki/lc/innerbeans/config.xml");
		Employee emp = (Employee) context.getBean("employee");
		System.out.println(emp.hashCode());
		Employee emp2= (Employee) context.getBean("employee");
		System.out.println(emp2.hashCode());

	}

}
