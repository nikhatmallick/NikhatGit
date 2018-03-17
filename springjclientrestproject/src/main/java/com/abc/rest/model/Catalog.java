package com.abc.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {
	protected static Logger logger = Logger.getLogger(Catalog.class.getName());
	@XmlElement
	private int catalog_id;
	@XmlElement
	private String catalog_name;

	public Catalog() {

	}

	public Catalog(int catalog_id, String catalog_name) {
		this.catalog_id = catalog_id;
		this.catalog_name = catalog_name;
	}

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
		StringBuilder buff = new StringBuilder("Catalog [").append("catalog_id: ")
				.append(getCatalog_id()).append(", catalog_name: ")
				.append(getCatalog_name()).append("]")
				;
		return buff.toString();
		
		//return "Catalog [catalog_id=" + catalog_id + ", catalog_name=" + catalog_name + "]";
	}

}
