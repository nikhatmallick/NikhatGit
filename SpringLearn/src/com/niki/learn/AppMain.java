package com.niki.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Person person = new Person();
		ApplicationContext context = new ClassPathXmlApplicationContext("com/niki/learn/bean/beans.xml");
		Person person = (Person) context.getBean("person");
		person.setTaxId(666);
		Address address = (Address) context.getBean("address");
		System.out.println(address);
		System.out.println(person);
		((ClassPathXmlApplicationContext) context).close();

	}

}
