package com.niki.spring.springjdbcprojectuci.products.model;

import java.util.Date;

public class Orders {
	private int order_id;
	private String order_created;
	private int order_amount;
	private int confirm_number;
	private String username;

	public Orders() {
	
	}
	public Orders(int order_id, String order_created, int order_amount, int confirm_number, String username) {
	//	super();
		this.order_id = order_id;
		this.order_created = order_created;
		this.order_amount = order_amount;
		this.confirm_number = confirm_number;
		this.username = username;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_created() {
		return order_created;
	}

	public void setOrder_created(String order_created) {
		this.order_created = order_created;
	}

	public int getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}

	public int getConfirm_number() {
		return confirm_number;
	}

	public void setConfirm_number(int confirm_number) {
		this.confirm_number = confirm_number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_created=" + order_created + ", order_amount=" + order_amount
				+ ", confirm_number=" + confirm_number + ", username=" + username + "]";
	}
}
