package com.abc.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "department")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {

	@XmlElement
	private int departmentId;
	
	@XmlElement
	private String departmentName;

	public Department() {
	}
	
	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(int departmentId) {
	    this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
	    this.departmentName = departmentName;
	}
	
	public String toString() {
        StringBuilder buff = new StringBuilder("[Department: ")
        .append("departmentId=").append(departmentId)
        .append(", departmentName=").append(departmentName)
        .append("]")
        ;

        return buff.toString();
	}
}
