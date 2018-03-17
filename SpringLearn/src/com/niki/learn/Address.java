package com.niki.learn;

public class Address {
	private String street;
	private String postalcode;

	public Address(String street, String postalcode) {
		this.street = street;
		this.postalcode = postalcode;
	}

	

	@Override
	public String toString() {
		return "Address [street=" + street + ", postalcode=" + postalcode + "]";
	}

}
