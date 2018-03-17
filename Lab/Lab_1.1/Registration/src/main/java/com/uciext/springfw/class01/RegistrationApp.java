package com.uciext.springfw.class01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import org.apache.log4j.Logger;

import com.uciext.springfw.class01.courses.service.CourseService;
import com.uciext.springfw.class01.courses.model.Course;

public class RegistrationApp {

   private static Logger logger = Logger.getLogger(RegistrationApp.class.getName());

   public static void main(String[] args) throws Exception {
      // Get instance of CourseService class
      BeanFactory factory = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/RegistrationContext.xml"));
      CourseService courseService = (CourseService) factory.getBean("courseService");

      // Make a call
      Course course1 = courseService.getCourse("X104");
      logger.info("Course X104: \n" + course1.toString());

      Course course2 = courseService.getCourse("X106");
      logger.info("Course X106: \n" + course2.toString());
   }
}
