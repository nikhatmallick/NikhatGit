package com.bharath.spring.springjavaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class Service {
	@Autowired
	Dao dao;
	
	public void save() {
		dao.create();
	}

}
