package com.niki.spring.springjdbcprojectuci.catalogs.service;

import java.util.List;

import com.niki.spring.springjdbcprojectuci.catalogs.model.Catalog;
import com.niki.spring.springjdbcprojectuci.products.model.Orders;
import com.niki.spring.springjdbcprojectuci.products.model.Product;
import com.niki.spring.springjdbcprojectuci.products.model.Product_Order;

public interface CatalogService {
	//catalog
	public void insertCatalog(Catalog catalog) ;
	public List<Catalog> getCatalogs();
	public Catalog getCatalog(int catalog_id);
	public void deleteCatalog(int catalog_id);
	public void updateCatalog(int catalog_id, String catalog_name);
	//product
	public void insertProduct(Product product);
	public List<Product> getProducts();
	public Product getProduct(int product_id);
	public List<Product> getProductsByCatalog(Catalog catalog);
	public void deleteProductbyId(int product_id);
	public void updateProduct(int product_id, Product product);
	//order
	public void insertOrder(Orders order);
	public List<Orders> getOrders();
	public Orders getOrderById(int order_id);
	public void deleteOrder(int order_id);
	public List<Orders> findOrdersByUserName(String username);
	public List<String> getUserName();
	//product_order
	public void insertProduct_Order(Product_Order product_order);
	public List<Product_Order> getProduct_Orders();
	public Product_Order getProduct_OrderById(int product_order_id);
}
