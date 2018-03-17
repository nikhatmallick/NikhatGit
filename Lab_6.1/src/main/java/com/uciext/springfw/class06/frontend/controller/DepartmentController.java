package com.uciext.springfw.class06.frontend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uciext.springfw.class06.courses.service.CourseService;
import com.uciext.springfw.class06.courses.model.Department;

@Controller
@RequestMapping("/department")
public class DepartmentController {
		
	private CourseService courseService;
	
//	@Inject
	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@RequestMapping("/list")
	public ModelAndView departmentList(Model model) {
		System.out.println("======= in departmentList");
		List<Department> departments = courseService.getDepartments();
		model.addAttribute("departmentList", departments);
		return new ModelAndView("department/departmentList");
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addDepartment(Model model) {
		System.out.println("======= in addDepartment");
		model.addAttribute(new Department());
		return "department/addDepartment";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addDepartmentSave(@Valid Department department, BindingResult bindingResult) {
		System.out.println("======= in addDepartmentSave");
		if(bindingResult.hasErrors()){
			return "department/addDepartment";
		}
		courseService.insertDepartment(department);
		return "redirect:/department/list.html";
	}
}
