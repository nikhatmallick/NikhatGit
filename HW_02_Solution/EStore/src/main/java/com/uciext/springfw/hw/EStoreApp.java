package com.uciext.springfw.hw;

import org.apache.log4j.Logger;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Product;
import com.uciext.springfw.hw.catalog.service.CatalogService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EStoreApp {

  private static Logger logger = Logger.getLogger(EStoreApp.class.getName());

  public static void main(String[] args) throws Exception {
	logger.info("Start");
	
	// Retrieve the bean using application context
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/EStoreContext.xml");
	CatalogService catalogService = context.getBean("catalogService", CatalogService.class);

    // Make a call
    Catalog catalog = catalogService.getCatalog();
    logger.info("Catalog: \n" + catalog.toString());
  
    logger.info("-------------------------");
    logger.info("Product 1:" + catalogService.getProduct("0596009208"));
    logger.info("Product 2:" + catalogService.getProduct("1935182358"));
    logger.info("Product 3:" + catalogService.getProduct("B00IPFBMS6"));
    logger.info("Product 4:" + catalogService.getProduct("C033983MS1"));
    
    logger.info("-----------------------------------");
   logger.info("Adding a valid product ...");
       try {
    	catalogService.addProduct(new Product("002247422", "spring MVA Bewginner's Guide", "ea",16.54F,5));
    } catch(Exception e) {}
   
    logger.info("Adding a product without a SKU ...");
    try {
    	catalogService.addProduct(new Product());
    } catch(Exception e) {}
    
    logger.info("Adding an undefined product ...");
    try {
    	catalogService.addProduct(null);
    } catch (Exception e) {}
    
  
  }
}
