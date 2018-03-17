package com.uciext.springfw.class07.frontend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uciext.springfw.class07.courses.model.Department;
import com.uciext.springfw.class07.courses.model.Items;
import com.uciext.springfw.class07.courses.service.CourseService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
		
	private CourseService courseService;
	
	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	// VIEW LIST OF DEPARTMENTS

	@RequestMapping("/list")
	public ModelAndView departmentList(Model model) {
		System.out.println("======= in departmentList");
		List<Department> departmentList = courseService.getDepartments();
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("selectedDepartments", new Items());
		return new ModelAndView("department/departmentList3");
	}

	// VIEW DEPARTMENT DETAILS

	@RequestMapping("/view")
	public ModelAndView departmentView(@RequestParam("deptId") int deptId, Model model) {
		System.out.println("======= in departmentView");
		Department department = courseService.getDepartment(deptId);
		model.addAttribute("department", department);
		return new ModelAndView("department/viewDepartment");
	}

	// UPDATE DEPARTMENT

	@RequestMapping(value="/edit/{departmentId}", method=RequestMethod.GET)
	public String editDepartment(@PathVariable int departmentId, Model model) {
		System.out.println("======= in editDepartment");
		Department department = courseService.getDepartment(departmentId);
		model.addAttribute("department", department);
		return "department/editDepartment";
	}
	
	@RequestMapping(value="/edit/{departmentId}", method=RequestMethod.POST)
	public String editDepartmentSave(@PathVariable int departmentId, 
			@Valid Department department, BindingResult bindingResult) {
		System.out.println("======= in editDepartmentSave");
		if(bindingResult.hasErrors()) {
			return "department/editDepartment";
		}
		courseService.updateDepartment(departmentId, department);
		return "redirect:/department/list.html";
	}

	// ADD DEPARTMENT
	
	// Before showing Add Department Form
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addDepartment(Model model) {
		System.out.println("======= in addDepartment");
		model.addAttribute(new Department());
		return "department/addDepartment";
	}

	// After submitting Add Department Form
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addDepartmentSave(@Valid Department department, BindingResult bindingResult) {
		System.out.println("======= in addDepartmentSave");
		if(bindingResult.hasErrors()){
			return "department/addDepartment";
		}
		courseService.insertDepartment(department);
		return "redirect:/department/list.html";
	}

	// DELETE DEPARTMENT

	// After submitting Delete from Department List Form
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String deleteDepartments(@ModelAttribute Items selectedDepartments) {
		System.out.println("======= in deleteDepartments");
		for (String deptIdStr : selectedDepartments.getItemList()) {
			System.out.println("delete department id=" + deptIdStr);
			try { 
				int deptId = Integer.parseInt(deptIdStr);
			    courseService.deleteDepartment(deptId);
			}
			catch (Exception e) {}
		}
		return "redirect:/department/list.html";
	}

}
