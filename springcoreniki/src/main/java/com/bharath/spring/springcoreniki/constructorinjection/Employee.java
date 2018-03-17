package com.bharath.spring.springcoreniki.constructorinjection;

public class Employee {

	private int id;
	private Address address;
	
	
	
	protected Employee(int id, Address address) {
		this.id = id;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", address=" + address + "]";
	}
	
	
}
