package com.uciext.springfw.class03.courses.model;

public class CourseDotNet extends Course {

	private DepartmentDotNet departmentDotNet;

	// byType - the return class needs to match
	public DepartmentDotNet getDepartment() {
		return departmentDotNet;
	}
	public void setDepartment(DepartmentDotNet value) {
		this.departmentDotNet = value;
	}	
}
