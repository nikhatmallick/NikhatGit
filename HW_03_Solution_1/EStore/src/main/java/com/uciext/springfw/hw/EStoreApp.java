package com.uciext.springfw.hw;

import org.apache.log4j.Logger;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.service.CatalogService;
import com.uciext.springfw.hw.config.AppConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EStoreApp {

  private static Logger logger = Logger.getLogger(EStoreApp.class.getName());

  public static void main(String[] args) throws Exception {
	logger.info("Start");
	
	// Retrieve the bean using application context
//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/EStoreContext.xml");
	
	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	CatalogService catalogService = context.getBean("catalogService", CatalogService.class);

    // Make a call
    Catalog catalog = catalogService.getCatalog();
    logger.info("Catalog: \n" + catalog.toString());
  
    logger.info("-------------------------");
    logger.info("Product 1:" + catalogService.getProduct("0596009208"));
    logger.info("Product 2:" + catalogService.getProduct("1935182358"));
    logger.info("Product 3:" + catalogService.getProduct("B00IPFBMS6"));
    logger.info("Product 4:" + catalogService.getProduct("C033983MS1"));
  
  }
}
