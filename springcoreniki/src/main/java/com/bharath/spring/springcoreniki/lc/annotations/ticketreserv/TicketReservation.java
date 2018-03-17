package com.bharath.spring.springcoreniki.lc.annotations.ticketreserv;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TicketReservation {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TicketReservation [id=" + id + "]";
	}
@PostConstruct
public void initialize() {
	System.out.println("after beans are instantiated and injected");
}
@PreDestroy
public void cleanup() {
	System.out.println("before the bean is destroyed");
}
}
