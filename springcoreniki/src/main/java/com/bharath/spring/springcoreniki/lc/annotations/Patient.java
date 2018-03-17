package com.bharath.spring.springcoreniki.lc.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Patient {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("inside setter method");
		this.id = id;
	}

	@PostConstruct
	public void hi() {
		System.out.println("Inside Hi Mehtod");
	}

	@PreDestroy
	public void bye() {
		System.out.println("inside Bye Mehtod");
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + "]";
	}

}
