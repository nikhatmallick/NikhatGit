package com.uciext.springfw.class07.courses.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "departmentList")
public class DepartmentList  {
	
	ArrayList<Department> departments = new ArrayList<Department>(); 
	
	public void setDepartments(ArrayList<Department> departments) {
		this.departments = departments;
	}
	
	public ArrayList<Department> getDepartments() {
		return departments;
	}
}
