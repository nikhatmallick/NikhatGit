package com.niki.spring.springjdbcprojectuci.products.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.niki.spring.springjdbcprojectuci.catalogs.model.Catalog;

@XmlRootElement(name = "productList")
public class ProductList {
	ArrayList<Product> products = new ArrayList<Product>();

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
}
