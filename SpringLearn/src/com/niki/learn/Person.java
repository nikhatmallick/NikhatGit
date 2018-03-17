package com.niki.learn;

public class Person {
	private int id;
	private String name;
	private int taxId;
	private Address address;
	

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Person() {

	}
	public void onCreate() {
		System.out.println("initialiazing ;bean created" + this);
	}
	//factory method, creating beans thru factory emthod instead of a constructor
	public static Person getInstance(int id, String name) {
		System.out.println("creating person using factory method");
		return new Person(id,name);
	}

	public void speaks() {
		System.out.println("person speaks...");
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId + ", address=" + address + "]";
	}

	

	
	

}
