package com.niki.spring.springjdbcprojectuci.rest;

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
import com.niki.spring.springjdbcprojectuci.products.model.ProductList;

@Controller
@RequestMapping("/rest")
public class ProductsRestService {
	private CatalogService catalogService;

	public CatalogService getCatalogService() {
		return catalogService;
	}

	@Autowired
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}
	
	//view all products
		@RequestMapping(value="/products", method=RequestMethod.GET)
		public @ResponseBody ProductList productsList() {
			System.out.println("======= in productsList (REST)");
			List<Product> prodList = catalogService.getProducts();
			System.out.println("rest product list zise " + prodList.size());
			
			// Convert
			ProductList productList = new ProductList();
			for (Product product : prodList) {
				productList.getProducts().add(product);
			}
			
			return productList;
		}
		// ADD Product
		
		@RequestMapping(value="/products", method=RequestMethod.POST)
		@ResponseStatus(HttpStatus.CREATED) 
		public void addProduct(@Valid @RequestBody Product product) {
			System.out.println("======= in addProduct (REST)");
			catalogService.insertProduct(product);
		}
		
		// VIEW Product  DETAILS by id

		@RequestMapping(value="/products/{product_id}", method=RequestMethod.GET)
		public @ResponseBody Product productView(@PathVariable("product_id") int product_id) {
			System.out.println("======= in departmentView (REST)");
			Product product = catalogService.getProduct(product_id);
			return product;
		}
}
