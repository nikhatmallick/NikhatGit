package com.niki.spring.springjdbcprojectuci.catalogs.dao;

import java.util.List;

import com.niki.spring.springjdbcprojectuci.products.model.Orders;

public interface OrdersDao {
	public void insertOrder(Orders order);
	public List<Orders> findOrders();
	public Orders findOrderById(int order_id);
	public void deleteOrder(int order_id);
	public List<Orders> findOrdersByUserName(String username);
	public List<String> getUserName();
	

}
