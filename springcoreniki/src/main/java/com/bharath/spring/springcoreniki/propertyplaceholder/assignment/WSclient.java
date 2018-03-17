package com.bharath.spring.springcoreniki.propertyplaceholder.assignment;

public class WSclient {
	private String url;
	private String userName;
	private String password;

	WSclient(String url, String userName, String password) {
		this.url = url;
		this.userName = userName;
		this.password = password;

	}

	@Override
	public String toString() {
		return "WSclient [url=" + url + ", userName=" + userName + ", password=" + password + "]";
	}

}
