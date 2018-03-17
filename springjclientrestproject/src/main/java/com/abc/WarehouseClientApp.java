package com.abc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.rest.client.CatalogClient;
import com.abc.rest.client.DepartmentClient;
import com.abc.rest.model.Catalog;
import com.abc.rest.model.Department;
import com.abc.rest.model.DepartmentList;
import com.abc.rest.model.Product;

public class WarehouseClientApp {

    public static void main(String[] args) throws Exception {
        WarehouseClientApp app = new WarehouseClientApp();
        app.run();
    }
    
    public void run() {
    	ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("/META-INF/spring/RegistrationClientContext.xml");
    	CatalogClient client = (CatalogClient) context.getBean("catalogClient");

        // Get departments
    	System.out.println("\n==== Get Catalogsclient ...");
    	ArrayList<Catalog> catalogs = client.getCatalogs();
    	System.out.println("---- Total catalogs=" + catalogs.size());
    	for (int i=0; i<catalogs.size(); i++) {
    	    System.out.println("[" + i + "]=" + catalogs.get(i));	
    	}
//Get Products
    	System.out.println("\n===== Get Products client...");
    	ArrayList<Product> products = client.getProducts();
    	System.out.println("----Total products="  + products.size());
     	for(int i=0;i<products.size(); i++) {
    		System.out.println("[" + i + "]="+ products.get(i))  ;
    	}
    //add new product
     	System.out.println("\n==== Add new Product client ...");
     	Product prod = new Product();
     	prod.setAvailable_quantity(200);
     	prod.setCatalog(catalogs.get(0));
     	prod.setProduct_id(0);
     	prod.setProduct_name("NikiBrandmakeup");
     	prod.setSku("skuoffoundation");
     	prod.setUom("billing");
     	client.createProduct(prod);
     	
     	products = client.getProducts();
    	for (int i=0; i<products.size(); i++) {
    	    System.out.println("prod[" + i + "]=" + products.get(i));
    	    if ("NikiBrandmakeup".equals(products.get(i).getProduct_name()))
    	    	prod = products.get(i);
    	}
     	
    	// Get departments by id
    /*	System.out.println("\n==== Get Catalogs by Id ...");
    	System.out.println("----   [id=" + catalogs.get(0).getCatalog_id() + "] " 
       			+ client.getCatalog(catalogs.get(0).getCatalog_id()));
       	System.out.println("----   [id=" + catalogs.get(0).getCatalog_id() + "] " 
       			+ client.getCatalog(catalogs.get(0).getCatalog_id()));
       	System.out.println("----   [id=" + catalogs.get(1).getCatalog_id() + "] " 
       			+ client.getCatalog(catalogs.get(1).getCatalog_id()));*/

       	// Add a new department
  /*  	System.out.println("\n==== Add new Department ...");
    	Department dept = new Department();
    	dept.setDepartmentName("Finance");
    	client.createDepartment(dept);

    	departments = client.getDepartments();
    	for (int i=0; i<departments.size(); i++) {
    	    System.out.println("dept[" + i + "]=" + departments.get(i));
    	    if ("Finance".equals(departments.get(i).getDepartmentName()))
    	    	dept = departments.get(i);
    	}
       	
      	// Update a department
    	System.out.println("\n==== Update a Department ...");
//    	dept = departments.get(departments.size()-1);
    	dept.setDepartmentName(dept.getDepartmentName() + "-2");
    	client.updateDepartment(dept);

    	departments = client.getDepartments();
    	for (int i=0; i<departments.size(); i++) {
    	    System.out.println("dept[" + i + "]=" + departments.get(i));	
    	}

       	// Delete a department
    	System.out.println("\n==== Delete a Department ...");
//    	dept = departments.get(departments.size()-1);
    	client.deleteDepartment(dept);

    	departments = client.getDepartments();
    	for (int i=0; i<departments.size(); i++) {
    	    System.out.println("dept[" + i + "]=" + departments.get(i));	
    	}*/
    }
}
