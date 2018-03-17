package com.uciext.springfw.class04.courses.model;

import org.springframework.stereotype.Component;

@Component("departmentJava")
public class DepartmentJava extends Department {

	public DepartmentJava() {
		super();
		setDeptName("Java  Department");
	}
}
