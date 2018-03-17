package com.uciext.springfw.class07.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.uciext.springfw.class07.courses.model.Department;
import com.uciext.springfw.class07.courses.model.DepartmentList;
import com.uciext.springfw.class07.courses.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Controller
@RequestMapping("/rest")
public class DepartmentsRestService {
		
	private CourseService courseService;
	
	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	// VIEW LIST OF DEPARTMENTS

	@RequestMapping(value="/departments", method=RequestMethod.GET)
	public @ResponseBody DepartmentList departmentsList() {
		System.out.println("======= in departmentsList (REST)");
		List<Department> deptList = courseService.getDepartments();
		
		// Convert
		DepartmentList departmentList = new DepartmentList();
		for (Department department : deptList) {
			departmentList.getDepartments().add(department);
		}
		
		return departmentList;
	}
	
	// VIEW DEPARTMENT DETAILS

	@RequestMapping(value="/departments/{deptId}", method=RequestMethod.GET)
	public @ResponseBody Department departmentView(@PathVariable("deptId") int deptId) {
		System.out.println("======= in departmentView (REST)");
		Department department = courseService.getDepartment(deptId);
		return department;
	}

	// UPDATE DEPARTMENT

	@RequestMapping(value="/departments/{departmentId}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void updateDepartment(@PathVariable int departmentId, 
			@Valid @RequestBody Department department) {
		System.out.println("======= in updateDepartment (REST)");
		courseService.updateDepartment(departmentId, department);
	}

	// ADD DEPARTMENT
	
	@RequestMapping(value="/departments", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED) 
	public void addDepartment(@Valid @RequestBody Department department) {
		System.out.println("======= in addDepartment (REST)");
		courseService.insertDepartment(department);
	}

	// DELETE DEPARTMENT

	@RequestMapping(value="/departments/{deptId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteDepartment(@PathVariable int deptId) {
		System.out.println("======= in deleteDepartment  (REST)");
	    courseService.deleteDepartment(deptId);
	}
}
