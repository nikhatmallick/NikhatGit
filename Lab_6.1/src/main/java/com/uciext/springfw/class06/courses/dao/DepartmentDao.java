package com.uciext.springfw.class06.courses.dao;

import java.util.List;

import com.uciext.springfw.class06.courses.model.Department;

public interface DepartmentDao {
	public void insertDepartment(Department department);
	public Department findDepartmentById(int departmentId);
	public List<Department> findDepartments();

}
