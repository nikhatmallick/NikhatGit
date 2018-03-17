package com.uciext.springfw.class04.courses.model;

import org.springframework.stereotype.Component;

@Component("departmentOOP")
public class DepartmentOOP extends Department {

	public DepartmentOOP() {
		super();
		setDeptName("OOP Department");
	}
}
