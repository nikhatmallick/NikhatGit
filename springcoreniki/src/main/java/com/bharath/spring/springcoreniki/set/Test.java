package com.bharath.spring.springcoreniki.set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bharath/spring/springcoreniki/set/setconfig.xml");
		CarDealer carde = (CarDealer) context.getBean("cardealer");
		System.out.println(carde.getName());
		System.out.println(carde.getModels());
		System.out.println(carde.getModels().getClass());
		

	}

}
