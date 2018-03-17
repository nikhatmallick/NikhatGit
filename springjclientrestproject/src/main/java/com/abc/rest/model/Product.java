package com.abc.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	@XmlElement
	private int product_id;
	@XmlElement
	private String sku;
	@XmlElement
	private String product_name;
	@XmlElement
	private int available_quantity;
	@XmlElement
	private String uom;
	@XmlElement
	private Catalog catalog;

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public Product() {
	}

	public Product(int product_id,   String sku, String product_name, int available_quantity, String uom,Catalog catalog) {
		this.product_id = product_id;
		this.sku = sku;
		this.product_name = product_name;
		this.available_quantity = available_quantity;
		this.uom = uom;
		this.catalog = catalog;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getAvailable_quantity() {
		return available_quantity;
	}
	public void setAvailable_quantity(int available_quantity) {
		this.available_quantity = available_quantity;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", sku=" + sku + ", product_name="
				+ product_name + ", available_quantity=" + available_quantity + ", uom=" + uom + "]";
	}



}
