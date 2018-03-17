package com.uciext.springfw.class03.courses.model;

public class CourseOOP extends Course {

	private DepartmentOOP departmentOOP;
	
	// constructor - only constructor parameter needs to match
	public CourseOOP(DepartmentOOP departmentOOP) {
		this.departmentOOP = departmentOOP;
	}

	public Department getDepartment() {
		return departmentOOP;
	}
}
