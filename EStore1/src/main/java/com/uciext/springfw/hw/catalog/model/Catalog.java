package com.uciext.springfw.hw.catalog.model;

public class Catalog {
	private String catalogName;
	private String lastUpdateDate;
	
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public String toString() {
		StringBuffer buff = new StringBuffer("[Catalog: ")
				.append("catalogName=").append(catalogName)
				.append(", lastUpdateDate=").append(lastUpdateDate)
				.append("]")
				;
		return buff.toString();
	}
	
	

}
