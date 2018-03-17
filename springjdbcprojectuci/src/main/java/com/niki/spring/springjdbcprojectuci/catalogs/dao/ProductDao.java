package com.niki.spring.springjdbcprojectuci.catalogs.dao;

import java.util.List;

import com.niki.spring.springjdbcprojectuci.catalogs.model.Catalog;
import com.niki.spring.springjdbcprojectuci.products.model.Product;

public interface ProductDao {
	public void insertProduct(Product product);
	public List<Product> findProducts();
	public Product findProductById(int product_id);
	public List<Product> findProductsByCatalog(Catalog catalog);
	public void deleteProductbyId(int product_id);
	public void updateProduct(int product_id, Product product);
}
