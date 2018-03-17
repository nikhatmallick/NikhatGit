package com.bharath.spring.springcoreniki.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bharath/spring/springcoreniki/properties/propconfig.xml");
		CountriesAndLanguages cl = (CountriesAndLanguages) context.getBean("countriesAndLangs");
		System.out.println(cl);

	}

}
