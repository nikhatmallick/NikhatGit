package com.Nikhat.spring.springprojectuci.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catalog")
public class Catalog {
	@Id
	@Column(name = "catalog_id")
	private int catalog_id;
	@Column(name = "catalog_name")
	private String catalog_name;

	public int getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}

	public String getCatalog_name() {
		return catalog_name;
	}

	public void setCatalog_name(String catalog_name) {
		this.catalog_name = catalog_name;
	}

	@Override
	public String toString() {
		return "Catalog [catalog_id=" + catalog_id + ", catalog_name=" + catalog_name + "]";
	}

}
