package com.abc.rest.client;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.abc.rest.model.Department;
import com.abc.rest.model.DepartmentList;

@Controller
public class DepartmentClient {

	private RestTemplate rest;
	
	@Autowired
	public void setRest(RestTemplate rest) {
		this.rest = rest;
	}
	
	// Get all departments
	public ArrayList<Department> getDepartments() {
		System.out.println("******** CLIENT: getDepartments");
		
		DepartmentList departmentList = rest.getForObject( 
		    "http://localhost:8080/rest/departments", DepartmentList.class);
		return departmentList.getDepartments();
	}	
	
	// Get a department by id
	public Department getDepartment(int deptId) {
		System.out.println("******** CLIENT: getDepartment");
		
		Department department = rest.getForObject( 
		    "http://localhost:8080/rest/departments/{id} ", 
		    Department.class, deptId);
		return department;
	}	
	
	// Create a new department
	public void createDepartment(Department dept) {
		System.out.println("******** CLIENT: createDepartment");
		
		ResponseEntity response = rest.postForEntity(
		    "http://localhost:8080/rest/departments", 
		    dept, null);
		if (response.getStatusCode() != HttpStatus.CREATED) {
			throw new RuntimeException("Error creating a department)");
		}
		
	}	
	
	// Update a new department
	public void updateDepartment(Department department) {
		System.out.println("******** CLIENT: updateDepartment");
		
		rest.put("http://localhost:8080/rest/departments/{deptId}", 
				department, department.getDepartmentId());
	}	
	
	// Delete a department
	public void deleteDepartment(Department dept) {
		System.out.println("******** CLIENT: deleteDepartment");
		
		rest.delete(
		    "http://localhost:8080/rest/departments/{deptId}", 
		    dept.getDepartmentId());
	}	
	
}
