package com.niki.learn;

public class PersonFactory {
	
	public Person createPerson(int id, String name) {
		System.out.println("using factory to create person");
		return	new Person(id,name);
	}

}
