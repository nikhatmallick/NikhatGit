package com.uciext.springfw.hw.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Product;
import com.uciext.springfw.hw.catalog.service.CatalogService;
import com.uciext.springfw.hw.catalog.service.impl.CatalogServiceImpl;

@Configuration
@ComponentScan("com.uciext")
public class AppConfig {
    @Bean
    public Product product1() {
        return new Product("0596009208", "Head First Java", "ea", 26.07F, 22);
    }

    @Bean
    public Product product2() {
        return new Product("1935182358", "Spring in Action", "ea", 31.66F, product1().getAvailableQuantity()*2);
    }
    
    @Bean
    public Product product3() {
        return new Product("B00IPFBMS6", "Professional Java for Web Applications", "ea", 38.99F, 122);
    }

    @Bean
    public Product product4() {
        return new Product("C033983MS1", "Package: " + product1().getName() + " + " + product3().getName(), "ea", 51.00F, 8);
    }

    @Bean
    public Catalog catalog() {
    	Map<String, Product> products = new HashMap<String, Product>();
    	products.put(product1().getSku(), product1());
    	products.put(product2().getSku(), product2());
    	products.put(product3().getSku(), product3());
    	products.put(product4().getSku(), product4());    	
    	Catalog catalog = new Catalog();
    	catalog.setCatalogName("Java Books");
    	catalog.setLastUpdateDate("06/05/2014");
    	catalog.setProducts(products);
    	return catalog;
//    	return new Catalog("Java Books", "06/05/2014", products);
    }

    @Bean(name="catalogService")
    public CatalogService catalogService() {
        return new CatalogServiceImpl();
    }
}
