package com.Nikhat.spring.springprojectuci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Nikhat.spring.springprojectuci.catalog.dao.CatalogDao;
import com.Nikhat.spring.springprojectuci.catalog.model.Catalog;

public class CatalogApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/Nikhat/spring/springprojectuci/ProjectConfig.xml");
		CatalogDao catalogDao = (CatalogDao) context.getBean("catalogDao");
		
		Catalog catalog = new Catalog();
		catalog.setCatalog_id(1);
		catalog.setCatalog_name("Cars");
		int result = catalogDao.create(catalog);
		System.out.println(catalog);
		
	}

}
