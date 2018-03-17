package com.uciext.springfw.class02;

import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.log4j.Logger;

import com.uciext.springfw.class02.courses.CourseMessages;
import com.uciext.springfw.class02.courses.model.Course;
import com.uciext.springfw.class02.courses.model.Instructor;
import com.uciext.springfw.class02.courses.service.CourseService;
import com.uciext.springfw.class02.courses.service.impl.CourseServiceImpl;

public class RegistrationApp {

    private static Logger logger = Logger.getLogger(RegistrationApp.class.getName());

    public static void main(String[] args) throws Exception {
    	// Retrieve the bean using application context
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/RegistrationContext.xml");
    	CourseService courseService = context.getBean("courseService", CourseService.class);

    	// Print all courses
        for (Course course : courseService.getCourses().values()) {
        	System.out.println(course);
        }

    	// Run expression language
        System.out.println("---------- Messages ------------------");
    	CourseMessages courseMessages1 = context.getBean("courseMessages", CourseMessages.class);
    	Properties messages = courseMessages1.getMessages();
        for (Object message : messages.values()) {
        	System.out.println(message);
        }

    	// Modify the Instructor's name
        
    	courseService.getCourse("X108").getInstructor().setFirstName("Mary Ann");
    	System.out.println(courseService.getCourse("X108").getInstructor());

    	// Print all courses
    	System.out.println("---- After the instructor is modified: ----");
    	CourseMessages courseMessages2 = context.getBean("courseMessages", CourseMessages.class);
    	messages = courseMessages2.getMessages();
        for (Object message : messages.values()) {
        	System.out.println(message);
        }
    }
}
