package com.abc.rest.client;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.abc.rest.model.Catalog;
import com.abc.rest.model.CatalogList;
import com.abc.rest.model.Product;
import com.abc.rest.model.ProductList;

@Controller
public class CatalogClient {

	private RestTemplate rest;
	
	@Autowired
	public void setRest(RestTemplate rest) {
		this.rest = rest;
	}
	
	// Get all catalogs
	public ArrayList<Catalog>  getCatalogs() {
		System.out.println("******** CLIENT: getCatalogs");
		
		CatalogList catalogList = rest.getForObject(
				"http://localhost:8080/rest/catalogs", CatalogList.class);
		return catalogList.getCatalogs();
	}	
	
	// Get a department by id
	public Catalog getCatalog(int catalog_id) {
		System.out.println("******** CLIENT: getCatalog");
		
		Catalog catalog = rest.getForObject( 
		    "http://localhost:8080/rest/catalogs/{catalog_id}", Catalog.class, catalog_id);
		return catalog;
	}	
	
	// Get all products
		public ArrayList<Product>  getProducts() {
			System.out.println("******** CLIENT: getProducts");
			
			ProductList productList = rest.getForObject("http://localhost:8080/rest/products", ProductList.class);
			 return productList.getProducts();
		}	
		
		//insert new product
		public void createProduct(Product prod) {
			System.out.println("******** CLIENT: createProduct");
			
			ResponseEntity response = rest.postForEntity(
			    "http://localhost:8080/rest/products", 
			    prod, null);
			if (response.getStatusCode() != HttpStatus.CREATED) {
				throw new RuntimeException("Error creating a product)");
			}
			
		}	
	
	// Create a new department
/*	public void createDepartment(Department dept) {
		System.out.println("******** CLIENT: createDepartment");
		
		ResponseEntity response = rest.postForEntity(
		    "http://localhost:8080/rest/departments", 
		    dept, null);
		if (response.getStatusCode() != HttpStatus.CREATED) {
			throw new RuntimeException("Error creating a department)");
		}
		
	}	
	
	// Update a new department
	public void updateDepartment(Department department) {
		System.out.println("******** CLIENT: updateDepartment");
		
		rest.put("http://localhost:8080/rest/departments/{deptId}", 
				department, department.getDepartmentId());
	}	
	
	// Delete a department
	public void deleteDepartment(Department dept) {
		System.out.println("******** CLIENT: deleteDepartment");
		
		rest.delete(
		    "http://localhost:8080/rest/departments/{deptId}", 
		    dept.getDepartmentId());
	}	
	*/
}
