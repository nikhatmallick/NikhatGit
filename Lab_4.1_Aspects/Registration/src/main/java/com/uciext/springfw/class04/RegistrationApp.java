package com.uciext.springfw.class04;

import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.uciext.springfw.class04.common.Util;
import com.uciext.springfw.class04.courses.model.Course;
import com.uciext.springfw.class04.courses.service.CourseService;
import com.uciext.springfw.class04.courses.service.DepartmentService;

public class RegistrationApp {

    public static void main(String[] args) throws Exception {
        RegistrationApp app = new RegistrationApp();
        app.run();
    }
    
    public void run() {
    	ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("/META-INF/spring/RegistrationContext.xml");
        CourseService courseService = (CourseService) context.getBean("courseService");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
/*
    	System.out.println("\n==== Get Courses ...");
        Map<String, Course> mapCourses = courseService.getCourses();
        Util.waitMS(5000);
        for (Course course : mapCourses.values()) {
        	System.out.println(course);
        }

    	System.out.println("\n==== Updating department ...");
        departmentService.updateDepartment("departmentDotNet", "Microsoft Certification");

        Map<String, Course> mapCourses2 = courseService.getCourses();
        for (Course course : mapCourses2.values()) {
        	System.out.println(course);
        }

    	System.out.println("\n==== Updating invalid department .... ");
    	try {
    		departmentService.updateDepartment("departmentDotNetX", "Microsoft CertificationX");
    	}
    	catch (Exception e) {
    		System.out.println("caught exception");
    	}

    	System.out.println("\n==== Getting a Java Course .... ");
        Course courseJava = courseService.getCourse("J112");
*/
    	System.out.println("\n==== Getting individual Courses and Departments .... ");
        courseService.getCourse("J112");
        courseService.getCourse("J114");
        courseService.getCourse("N203");
        departmentService.getDepartment("departmentJava");
        departmentService.getDepartment("departmentDotNet");

    }
}
