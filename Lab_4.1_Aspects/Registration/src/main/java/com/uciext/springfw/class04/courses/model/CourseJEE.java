package com.uciext.springfw.class04.courses.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CourseJEE extends Course {

	private Department department;
	
	public Department getDepartment() {
		return department;
	}

	// Wired by input parameter class type
	@Autowired
	@Qualifier("departmentJava")
	public void setDepartment(Department value) {
		this.department = value;
	}
}
