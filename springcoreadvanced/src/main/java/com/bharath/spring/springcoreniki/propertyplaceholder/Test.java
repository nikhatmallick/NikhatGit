package com.bharath.spring.springcoreniki.propertyplaceholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/bharath/spring/springcoreniki/propertyplaceholder/config.xml");
		MyDAO mydao = (MyDAO) context.getBean("myDAO");
		System.out.println(mydao);

	}

}
