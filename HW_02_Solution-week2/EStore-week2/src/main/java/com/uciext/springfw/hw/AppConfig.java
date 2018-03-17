package com.uciext.springfw.hw;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Product;
import com.uciext.springfw.hw.catalog.service.CatalogService;
import com.uciext.springfw.hw.catalog.service.impl.CatalogServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public Product product1() {
		return new Product("0596009208", "Head First Java", "ea", 26.07F, 22);
	}
	
	@Bean
	public Product product2() {
		return new Product("1935182358", "Spring in action", "ea", 31.66F, product1().getAvailableQuantity()*2);
	}
	
	@Bean
	public Product product3() {
		return new Product("1935182358", "log4j", "ea", 31.66F, 55);
	}
	@Bean
	public Product product4() {
		return new Product("1935182358", product1().getName()+" "+product3().getName(), "ea", 31.66F, 66);
	}
	
	@Bean
	public Map<String,Product> products(){
		Map<String, Product> products = new HashMap<String,Product>();
		products.put(product1().getSku(), product1());
		products.put(product2().getSku(), product2());
		products.put(product3().getSku(), product3());
		products.put(product4().getSku(), product4());
		return products;
	}
	
	@Bean
	public Catalog catalog() {
		
		Catalog catalog =  new Catalog();
		catalog.setCatalogName("IT Books");
		catalog.setLastUpdateDate("02/10/2018");
		return catalog;
		
	}

	@Bean CatalogService catalogService() {
		return new CatalogServiceImpl();
	}
	
}
