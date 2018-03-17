package com.niki.spring.springjdbcprojectuci.catalogs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.niki.spring.springjdbcprojectuci.catalogs.dao.CatalogDao;
import com.niki.spring.springjdbcprojectuci.catalogs.dao.OrdersDao;
import com.niki.spring.springjdbcprojectuci.catalogs.dao.ProductDao;
import com.niki.spring.springjdbcprojectuci.catalogs.dao.Product_OrderDao;
import com.niki.spring.springjdbcprojectuci.catalogs.model.Catalog;
import com.niki.spring.springjdbcprojectuci.catalogs.service.CatalogService;
import com.niki.spring.springjdbcprojectuci.products.model.Orders;
import com.niki.spring.springjdbcprojectuci.products.model.Product;
import com.niki.spring.springjdbcprojectuci.products.model.Product_Order;

public class CatalogServiceImpl implements CatalogService {

	static final Logger logger = Logger.getLogger(CatalogServiceImpl.class.getName());
	CatalogDao catalogDao;
	ProductDao productDao;
	OrdersDao ordersDao;
	Product_OrderDao product_orderDao;

	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void setCatalogDao(CatalogDao catalogDao) {
		this.catalogDao = catalogDao;
	}
	
	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	public void setProduct_orderDao(Product_OrderDao product_orderDao) {
		this.product_orderDao = product_orderDao;
	}

	
	// Catalogs
	@Override
	public void insertCatalog(Catalog catalog) {
		System.out.println("insert this catalog: " + catalog);
		catalogDao.insertCatalog(catalog);

	}

	@Override
	public List<Catalog> getCatalogs() {
		System.out.println("all teh catalogs:");
		return catalogDao.findCatalogs();
	}

	@Override
	public Catalog getCatalog(int catalog_id) {
		return catalogDao.findCatalogById(catalog_id);
	}
	
	@Override
	public void deleteCatalog(int catalog_id) {
		catalogDao.deleteCatalog(catalog_id);
		
	}

	@Override
	public void updateCatalog(int catalog_id, String catalog_name) {
		catalogDao.updateCatalog(catalog_id, catalog_name);
	}


	
//product
	@Override
	public void insertProduct(Product product) {
		productDao.insertProduct(product);
	}

	@Override
	public List<Product> getProducts() {
		return productDao.findProducts();
	}

	@Override
	public Product getProduct(int product_id) {
		return productDao.findProductById(product_id);
	}


	@Override
	public List<Product> getProductsByCatalog(Catalog catalog) {
		System.out.println("--- getProductsByCatalog() catalog=" + catalog);
		return productDao.findProductsByCatalog(catalog);
	}

	@Override
	public void insertOrder(Orders order) {
		ordersDao.insertOrder(order);
	}

	@Override
	public List<Orders> getOrders() {
		return ordersDao.findOrders();
	}

	@Override
	public Orders getOrderById(int order_id) {
		return ordersDao.findOrderById(order_id);
	}

	@Override
	public void deleteOrder(int order_id) {
		ordersDao.deleteOrder(order_id);
	}

	@Override
	public void insertProduct_Order(Product_Order product_order) {
		product_orderDao.insertProduct_Order(product_order);
	}

	@Override
	public List<Product_Order> getProduct_Orders() {
		return product_orderDao.findProduct_Orders();
	}

	@Override
	public Product_Order getProduct_OrderById(int product_order_id) {
		return product_orderDao.findProduct_OrderById(product_order_id);
	}

	@Override
	public void deleteProductbyId(int product_id) {
		productDao.deleteProductbyId(product_id);
		
	}

	@Override
	public void updateProduct(int product_id, Product product) {
		productDao.updateProduct(product_id, product);
	}

	
	
	

}
