package com.niki.spring.springjdbcprojectuci.catalogs.dao;

import java.util.List;

import com.niki.spring.springjdbcprojectuci.catalogs.model.Catalog;
public interface CatalogDao {

	public void insertCatalog(Catalog catalog) ;
	public List<Catalog> findCatalogs();
	public Catalog findCatalogById(int catalog_id);
	public void deleteCatalog(int catalog_id);
	public void updateCatalog(int catalog_id, String catalog_name);
}
