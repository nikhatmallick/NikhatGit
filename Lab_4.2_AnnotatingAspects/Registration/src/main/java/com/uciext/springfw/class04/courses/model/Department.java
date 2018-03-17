package com.uciext.springfw.class04.courses.model;

public class Department {

	private String deptName;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
	    this.deptName = deptName;
	}
	
	public String toString() {
        StringBuilder buff = new StringBuilder("[Department: ")
        .append("deptName=").append(deptName)
        .append("]")
        ;

        return buff.toString();
	}
}
