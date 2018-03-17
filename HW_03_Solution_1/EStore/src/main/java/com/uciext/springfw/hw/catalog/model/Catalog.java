package com.uciext.springfw.hw.catalog.model;

import java.lang.StringBuilder;
import java.util.Map;

public class Catalog {

	// Properties
    private String catalogName;
    private String lastUpdateDate;
    private Map<String, Product> products;

//    public Catalog(String catalogName, String lastUpdateDate, 
//    		Map<String, Product> products) {
//    	this.catalogName = catalogName;
//    	this.lastUpdateDate = lastUpdateDate;
//    	this.products = products;
//    }
    
    public String getCatalogName() {
        return catalogName;
    }
    public void setCatalogName(String value) {
        this.catalogName = value;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }
    public void setLastUpdateDate(String value) {
        this.lastUpdateDate = value;
    }

    public Map<String, Product> getProducts() {
        return products;
    }
    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    public Product getProduct(String sku) {
        return products.get(sku);
    }

    public String toString() {
       StringBuilder buff = new StringBuilder("[Catalog: ")
       .append("catalogName=").append(catalogName)
       .append(", lastUpdateDate=").append(lastUpdateDate)
       .append(", products=");
       for (Product product : products.values()) {
    	   buff.append(product).append(", ");
       }
       buff.append("]");

       return buff.toString();
    }
}
