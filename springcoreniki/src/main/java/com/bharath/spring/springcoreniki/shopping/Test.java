package com.bharath.spring.springcoreniki.shopping;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bharath/spring/springcoreniki/shopping/shoppingcart.xml");
		ShoppingCart sc = (ShoppingCart) context.getBean("shoppingcart");
		System.out.println(sc);

	}

}
