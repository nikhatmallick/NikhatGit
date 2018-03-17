package com.uciext.springfw.class04.courses.model;

import org.springframework.beans.factory.annotation.Autowired;

public class CourseJava extends Course {

	private DepartmentJava departmentJava;
	
	public DepartmentJava getDepartment() {
		return departmentJava;
	}

	// Wired by input parameter class type
	@Autowired
	public void setDepartment(DepartmentJava value) {
		this.departmentJava = value;
	}

}
