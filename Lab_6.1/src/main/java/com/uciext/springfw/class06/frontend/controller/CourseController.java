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
import com.uciext.springfw.class06.courses.model.Course;

@Controller
@RequestMapping("/course")
public class CourseController {
		
	private CourseService courseService;
	
//	@Inject
	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@RequestMapping("/list")
	public ModelAndView courseList(Model model) {
		System.out.println("======= in courseList");
		List<Course> courses = courseService.getCourses();
		model.addAttribute("courseList", courses);
		return new ModelAndView("course/courseList");
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addCourse(Model model) {
		System.out.println("======= in addCourse");
		model.addAttribute(new Course());
		model.addAttribute("departmentList", courseService.getDepartments());
		
		return "course/addCourse";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addCourseSave(@Valid Course course, BindingResult bindingResult) {
		System.out.println("======= in addCourseSave");
		if(bindingResult.hasErrors()){
			return "course/addCourse";
		}
		courseService.insertCourse(course);
		return "redirect:/course/list";
	}
}
