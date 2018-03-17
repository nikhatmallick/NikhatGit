package com.uciext.springfw.class02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.apache.log4j.Logger;

import com.uciext.springfw.class02.courses.model.Course;
import com.uciext.springfw.class02.courses.service.CourseService;
import com.uciext.springfw.class02.courses.service.impl.CourseServiceImpl;

public class RegistrationApp {

    private CourseService courseService;
    
    public static void main(String[] args) throws Exception {
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/RegistrationContext.xml"));
        CourseService courseService = (CourseService) factory.getBean("courseService");

    	// Print all courses
        for (Course course : courseService.getCourses().values()) {
        	System.out.println(course);
        }

    	// Modify the Instructor's name
    	courseService.getCourse("X104").getInstructor().setFirstName("John William");
    	courseService.getCourse("X108").getInstructor().setFirstName("Mary Ann");

    	// Print all courses
    	System.out.println("---- After the instructor is modified: ----");
        for (Course course : courseService.getCourses().values()) {
        	System.out.println(course);
        }
    }
}
