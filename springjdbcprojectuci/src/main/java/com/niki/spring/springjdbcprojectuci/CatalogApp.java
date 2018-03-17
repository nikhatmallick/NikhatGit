package com.niki.spring.springjdbcprojectuci;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niki.spring.springjdbcprojectuci.catalogs.model.Catalog;
import com.niki.spring.springjdbcprojectuci.catalogs.service.CatalogService;
import com.niki.spring.springjdbcprojectuci.products.model.Product;

@SpringBootApplication
@ImportResource(locations = {
"file:./src/main/resources/META-INF/spring/CatalogConfig.xml"
})
public class CatalogApp {
	
	public static void main(String[] args) {

		SpringApplication.run(CatalogApp.class, args);
		CatalogApp app = new CatalogApp();
		app.run();
	}
	
	public void run() {
	ApplicationContext	context = new ClassPathXmlApplicationContext("/META-INF/spring/CatalogConfig.xml");
	 CatalogService catalogService = (CatalogService)context.getBean("catalogService");
	   // Courses
 	System.out.println("\n==== Get Catalogs ...");
     List<Catalog> catalogs = catalogService.getCatalogs();
 	System.out.println("---- Total catalogs=" + catalogs.size());
     for (Catalog catalog : catalogs) {
     	System.out.println("----   " + catalog);
     }

     if (catalogs.size() == 0) {
     	System.out.println("\n==== Insert catalogs ...");
     	catalogService.insertCatalog(new Catalog(0,"Cars"));
     	catalogService.insertCatalog(new Catalog(0,"Cars01"));
     	catalogService.insertCatalog(new Catalog(0,"Kitchen"));

     	System.out.println("\n==== Get Catalogs after the Insert ...");
     	catalogs = 	catalogService.getCatalogs();
     	System.out.println("---- Total courses=" + catalogs.size());
         for (Catalog catalog : catalogs) {
         	System.out.println("after INSERT----   " + catalog);
         }
     }
 	System.out.println("\n==== Get catalogs by Id ...");
   	System.out.println("----   [id=" + catalogs.get(0).getCatalog_id() + "] " 
   			+ catalogService.getCatalog(catalogs.get(0).getCatalog_id()));
   	System.out.println("----   [id=" + catalogs.get(1).getCatalog_id() + "] " 
   			+ catalogService.getCatalog(catalogs.get(1).getCatalog_id()));

    catalogs = catalogService.getCatalogs();  // Reset the list
    //update catalog
    System.out.println("==============Updating catalog name===============");
    catalogService.updateCatalog(catalogs.get(0).getCatalog_id(), "thisisUpdatedcatalog");
    System.out.println("===========catalog updated===============");
    catalogs = catalogService.getCatalogs();  // Reset the list
    for (Catalog catalog : catalogs) {
     	System.out.println("after UPDATE----   " + catalog);
     }
    //delete catalog
    System.out.println("=====Delete one Catalog=======");
    System.out.println("deleting catalog: " + catalogs.get(1).getCatalog_id() + " with name "+ catalogs.get(1).getCatalog_name());
    catalogService.deleteCatalog(catalogs.get(1).getCatalog_id());
    //products
    System.out.println("Get Producgts ");
     List<Product> products = catalogService.getProducts();
     System.out.println("total products = "+ products.size());
    for(Product product : products) {
    	 System.out.println("-------------"+ product);
     }
     if(products.size() ==0) {
    	 System.out.println("\n================ Insert Products........");
    	 catalogService.insertProduct(new Product(0,"6886uuy","audi",2,"number",catalogs.get(0)));
    	 catalogService.insertProduct(new Product(0,"hhhh888778","bmw",3,"number",catalogs.get(0)));
    	 catalogService.insertProduct(new Product(0,"sssssss","spoons",20,"count",catalogs.get(0)));
     }
     System.out.println("\n==== Get products for catalog  Cars ...");
    products = catalogService.getProductsByCatalog(catalogs.get(0));
 	System.out.println("---- Total products=" + products.size());
     for (Product product : products) {
     	System.out.println("----   " + product);
     }

     products = catalogService.getProducts(); // Reset the list
     System.out.println("++++++++++++++FINAL CALL TO LIST ALL PRODUCTS+++++++++++++++++++++");
     for(Product product : products) {
    	 System.out.println("-------------"+ product);
    	System.out.println(product.getProduct_id()+ " "+ product.getProduct_name()+ " "+
    	product.getSku()+ " "+ product.getUom()+ " " + product.getCatalog().getCatalog_id() ); 
     }

	}

}
