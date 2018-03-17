package com.uciext.springfw.class03.courses.model;

import org.springframework.beans.factory.annotation.Autowired;

public class CourseDotNet extends Course {

	// Wired by input parameter class type
	@Autowired
	private DepartmentDotNet departmentDotNet;

	public DepartmentDotNet getDepartment() {
		return departmentDotNet;
	}
	public void setDepartment(DepartmentDotNet value) {
		this.departmentDotNet = value;
	}	
}
