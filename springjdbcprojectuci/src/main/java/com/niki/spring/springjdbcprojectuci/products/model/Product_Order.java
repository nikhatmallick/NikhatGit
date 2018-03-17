package com.niki.spring.springjdbcprojectuci.products.model;

public class Product_Order {
	private int product_order_id;
	private int order_id;
	private int product_id;
	private Double order_amount;

	public void setProduct_order_id(int product_order_id) {
		this.product_order_id = product_order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setOrder_amount(Double order_amount) {
		this.order_amount = order_amount;
	}
	
	public  Product_Order() {
		
	}

	public Product_Order(int product_order_id, int order_id, int product_id, Double order_amount) {
		super();
		this.product_order_id = product_order_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.order_amount = order_amount;
	}

	@Override
	public String toString() {
		return "Product_Order [product_order_id=" + product_order_id + ", order_id=" + order_id + ", product_id="
				+ product_id + ", order_amount=" + order_amount + "]";
	}

	public int getProduct_order_id() {
		return product_order_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public Double getOrder_amount() {
		return order_amount;
	}

}
