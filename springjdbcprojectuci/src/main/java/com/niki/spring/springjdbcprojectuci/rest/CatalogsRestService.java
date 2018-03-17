package com.niki.spring.springjdbcprojectuci.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niki.spring.springjdbcprojectuci.catalogs.model.Catalog;
import com.niki.spring.springjdbcprojectuci.catalogs.model.CatalogList;
import com.niki.spring.springjdbcprojectuci.catalogs.service.CatalogService;
import com.niki.spring.springjdbcprojectuci.products.model.Product;

@Controller
@RequestMapping("/rest")
public class CatalogsRestService {

	private CatalogService catalogService;

	@Autowired
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}
	
	//view all catalogs
	@RequestMapping(value="/catalogs", method=RequestMethod.GET)
	public @ResponseBody CatalogList catalogsList() {
		System.out.println("======= in catalogsList (REST)");
		List<Catalog> catList = catalogService.getCatalogs();
		
		// Convert
		CatalogList catalogList = new CatalogList();
		for (Catalog catalog : catList) {
			catalogList.getCatalogs().add(catalog);
		}
		
		return catalogList;
	}
	
	// ADD CATALOG
	
		@RequestMapping(value="/catalogs", method=RequestMethod.POST)
		@ResponseStatus(HttpStatus.CREATED) 
		public void addCatalog(@Valid @RequestBody Catalog catalog) {
			System.out.println("======= in addCatalog (REST)");
			catalogService.insertCatalog(catalog);
		}
			
	 
		// VIEW Catalog  DETAILS by id

				@RequestMapping(value="/catalogs/{catalog_id}", method=RequestMethod.GET)
				public @ResponseBody Catalog catalogView(@PathVariable("catalog_id") int catalog_id) {
					System.out.println("======= in departmentView (REST)");
					Catalog catalog = catalogService.getCatalog(catalog_id);
					return catalog;
				}
}
