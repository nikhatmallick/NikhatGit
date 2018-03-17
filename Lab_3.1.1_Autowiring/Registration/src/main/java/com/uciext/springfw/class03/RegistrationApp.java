package com.uciext.springfw.class03;

import java.util.Collection;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;

import com.uciext.springfw.class03.courses.model.Course;
import com.uciext.springfw.class03.courses.service.CourseService;

public class RegistrationApp {

    public static void main(String[] args) throws Exception {
    	ClassPathXmlApplicationContext context = 
            new ClassPathXmlApplicationContext("/META-INF/spring/RegistrationContext.xml");
        CourseService courseService = (CourseService) context.getBean("courseService");

        Map<String, Course> mapCourses = courseService.getCourses();
        for (Course course : mapCourses.values()) {
       	   System.out.println(course);
        }
    }
}
