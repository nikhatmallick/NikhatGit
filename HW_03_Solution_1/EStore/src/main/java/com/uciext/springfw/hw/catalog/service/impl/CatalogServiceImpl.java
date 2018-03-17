package com.uciext.springfw.hw.catalog.service.impl;

import org.apache.log4j.Logger;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Product;
import com.uciext.springfw.hw.catalog.service.CatalogService;

import org.springframework.beans.factory.annotation.Autowired;

public class CatalogServiceImpl implements CatalogService {

    private static Logger logger = Logger.getLogger("com.uciext.springfw.hw.catalog.service.impl.CatalogServiceImpl");

	public CatalogServiceImpl() {
	    logger.info("In CatalogServiceImpl()");
	}

	@Autowired
    private Catalog catalog;
   	
	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public Product getProduct(String sku) {
		return catalog.getProduct(sku);
	}
}
