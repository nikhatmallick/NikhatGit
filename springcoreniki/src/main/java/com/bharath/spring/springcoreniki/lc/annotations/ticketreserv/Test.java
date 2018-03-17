package com.bharath.spring.springcoreniki.lc.annotations.ticketreserv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/bharath/spring/springcoreniki/lc/annotations/ticketreserv/configannotation.xml");
		TicketReservation tr = (TicketReservation) context.getBean("ticketreservation");
		System.out.println(tr);
		context.registerShutdownHook();
	}

}
