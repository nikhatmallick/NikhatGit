package com.uciext.springfw.class04.courses.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseOOP extends Course {

	private DepartmentOOP departmentOOP;
	
	public CourseOOP() {
	}
	
	// Wired by constructor - only constructor parameter needs to match
	@Autowired
	public CourseOOP(DepartmentOOP departmentOOP) {
		this.departmentOOP = departmentOOP;
	}

	public Department getDepartment() {
		return departmentOOP;
	}
}
