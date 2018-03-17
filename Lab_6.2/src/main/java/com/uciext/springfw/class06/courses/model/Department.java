package com.uciext.springfw.class06.courses.model;

import javax.validation.constraints.Size;

public class Department {

	private int departmentId;
	
	@Size(min=3, max=15, message="Department name must be between 3 and 15 characters long.") 
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
