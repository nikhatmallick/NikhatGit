package com.uciext.springfw.hw.catalog.model;

import java.lang.StringBuilder;

public class Catalog {

	// Properties
    private String catalogName;
    private String lastUpdateDate;

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

    public String toString() {
       StringBuilder buff = new StringBuilder("[Catalog: ")
       .append("catalogName=").append(catalogName)
       .append(", lastUpdateDate=").append(lastUpdateDate)
       .append("]")
       ;

       return buff.toString();
    }
}
