package com.bharath.spring.springcoreniki.required;

import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bharath/spring/springcoreniki/required/config.xml");
		University univ = (University) context.getBean("university");
		System.out.println(univ);
	}

}
