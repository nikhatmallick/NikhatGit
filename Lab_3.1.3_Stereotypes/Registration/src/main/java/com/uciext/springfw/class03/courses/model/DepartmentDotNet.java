package com.uciext.springfw.class03.courses.model;

import org.springframework.stereotype.Component;

@Component("departmentDotNet")
public class DepartmentDotNet extends Department {

	public DepartmentDotNet() {
		super();
		setDeptName(".Net  Department");
	}
}
