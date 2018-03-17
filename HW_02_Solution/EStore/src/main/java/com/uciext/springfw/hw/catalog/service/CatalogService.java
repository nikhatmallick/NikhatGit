package com.uciext.springfw.hw.catalog.service;

import java.util.List;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Product;

public interface CatalogService {
	public Catalog getCatalog();
	public Product getProduct(String sku);
	public void addProduct(Product prod );
}
