package com.uciext.springfw.class05.courses.model;

public class Product {
private int product_id;
private int catalog_id;
private String sku;
private String product_name;
private int available_quantity;
private String uom;

protected Product() {
}

protected Product(int product_id, int catalog_id, String sku, String product_name, int available_quantity, String uom) {
	this.product_id = product_id;
	this.catalog_id = catalog_id;
	this.sku = sku;
	this.product_name = product_name;
	this.available_quantity = available_quantity;
	this.uom = uom;
}
public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public int getCatalog_id() {
	return catalog_id;
}
public void setCatalog_id(int catalog_id) {
	this.catalog_id = catalog_id;
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
	return "Product [product_id=" + product_id + ", catalog_id=" + catalog_id + ", sku=" + sku + ", product_name="
			+ product_name + ", available_quantity=" + available_quantity + ", uom=" + uom + "]";
}


}
