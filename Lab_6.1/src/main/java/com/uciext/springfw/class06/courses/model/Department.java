package com.uciext.springfw.class06.courses.model;

public class Department {

	private int departmentId;
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
