package com.uciext.springfw.class03.courses.model;

import org.springframework.stereotype.Component;

@Component("departmentOOP")
public class DepartmentOOP extends Department {

	public DepartmentOOP() {
		super();
		setDeptName("OOP Department");
	}
}
