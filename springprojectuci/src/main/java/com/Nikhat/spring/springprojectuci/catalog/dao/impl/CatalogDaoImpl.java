package com.Nikhat.spring.springprojectuci.catalog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;

import com.Nikhat.spring.springprojectuci.catalog.dao.CatalogDao;
import com.Nikhat.spring.springprojectuci.catalog.model.Catalog;

@Component("catalogDao")
public class CatalogDaoImpl implements CatalogDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	@Transactional
	public int create(Catalog catalog) {
		Integer result = (Integer) hibernateTemplate.save(catalog);
		return result;
	}

}
