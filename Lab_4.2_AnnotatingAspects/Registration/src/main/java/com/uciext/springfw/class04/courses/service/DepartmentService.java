package com.uciext.springfw.class04.courses.service;

import java.util.Map;

import com.uciext.springfw.class04.courses.model.Department;

public interface DepartmentService {
	public Department getDepartment(String departmentId);
	public void updateDepartment(String departmentId, String deptName);
	public Map<String, Department> getDepartments();
}
