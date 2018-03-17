package com.uciext.springfw.hw.catalog.service.impl;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.service.CatalogService;

public class CatalogServiceImpl implements CatalogService{
	private Catalog catalog1;

	@Override
	public Catalog getCatalog(String catalogName) {
		// TODO Auto-generated method stub
			return catalog1;
	}

	public Catalog getCatalog1() {
		return catalog1;
	}

	public void setCatalog1(Catalog value) {
		this.catalog1 = value;
	}
	
	

}
