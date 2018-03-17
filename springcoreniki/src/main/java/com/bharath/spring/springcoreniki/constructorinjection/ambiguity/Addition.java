package com.bharath.spring.springcoreniki.constructorinjection.ambiguity;

public class Addition {
	
	Addition(int a, double b){
		System.out.println("inside constructor ");
		System.out.println(a);
		System.out.println(b);
	}

	
/*	Addition(double a, double b){
		System.out.println("inside constructor Double");
	}
	
	Addition(int a, int b){
		System.out.println("inside constructor INT");
	}

	Addition(String a, String b){
		System.out.println("inside constructor String");
	}*/

}
