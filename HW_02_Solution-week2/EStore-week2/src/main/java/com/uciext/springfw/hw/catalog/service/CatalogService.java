package com.uciext.springfw.hw.catalog.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Product;

@Component
public interface CatalogService {
	public Catalog getCatalog();
	public Product getProduct(String sku);
}
