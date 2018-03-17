package com.niki.spring.springjdbcprojectuci.catalogs.dao;

import java.util.List;

import com.niki.spring.springjdbcprojectuci.products.model.Product_Order;

public interface Product_OrderDao {
	public void insertProduct_Order(Product_Order product_order);
	public List<Product_Order> findProduct_Orders();
	public Product_Order findProduct_OrderById(int product_order_id);

}
