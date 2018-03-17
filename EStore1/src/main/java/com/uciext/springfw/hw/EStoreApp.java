package com.uciext.springfw.hw;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.service.CatalogService;

public class EStoreApp {

	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		BeanFactory factory = new XmlBeanFactory(new  ClassPathResource("/META-INF/spring/EStoreContext.xml"));
		CatalogService catalogService = (CatalogService) factory.getBean("catalogService");
		
		Catalog catalog1 = catalogService.getCatalog("Java Book");
		System.out.println(catalog1.toString());

	}

}
