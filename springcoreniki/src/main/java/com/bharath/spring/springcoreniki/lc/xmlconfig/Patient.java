package com.bharath.spring.springcoreniki.lc.xmlconfig;

public class Patient {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("inside setter method");
		this.id = id;
	}

	public void hi() {
		System.out.println("Inside Hi Mehtod");
	}

	public void bye() {
		System.out.println("inside Bye Mehtod");
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + "]";
	}

}
