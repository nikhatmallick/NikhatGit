package com.uciext.springfw.class03.courses.model;

public class CourseJava extends Course {

	private DepartmentJava departmentJava;
	
	// byName - the method name needs to match
	public DepartmentJava getDepartmentJava() {
		return departmentJava;
	}
	public void setDepartmentJava(DepartmentJava value) {
		this.departmentJava = value;
	}

	public Department getDepartment() {
		return getDepartmentJava();
	}

}
