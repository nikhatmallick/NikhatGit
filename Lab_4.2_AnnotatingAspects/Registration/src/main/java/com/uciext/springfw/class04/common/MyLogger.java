package com.uciext.springfw.class04.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.uciext.springfw.class04.courses.model.Course;

@Aspect
public class MyLogger {

	// Log before and after getCourses
	@Pointcut("execution(* com.uciext.springfw.class04.courses.service.CourseService.getCourses(..))")
	public void getCoursesPointcut() {}

	@Before("getCoursesPointcut()")
	public void logBefore() {
    	System.out.println("   Log before getCourses");
    }

	@After("getCoursesPointcut()")
    public void logAfter() {
    	System.out.println("   Log after getCourses");
    }
	
	@AfterThrowing("getCoursesPointcut()")
    public void logError() {
    	System.out.println("   Log error getCourses");
    }

	// Log update department 
	@Pointcut("execution(* com.uciext.springfw.class04.courses.service.DepartmentService.updateDepartment(..))")
	public void updateDepartmentPointcut() {}

	@Before("updateDepartmentPointcut()")
    public void logBeforeDepartment() {
    	System.out.println("   Log before updateDepartment");
    }

	@After("updateDepartmentPointcut()")
    public void logAfterDepartment() {
    	System.out.println("   Log after updateDepartment");
    }
	
	@AfterThrowing("updateDepartmentPointcut()")
    public void logErrorDepartment() {
    	System.out.println("   Log error in updateDepartment");
    }

    // Log everything in services
	@Pointcut("execution(* com.uciext.springfw.class04.courses.service.*.*(..))")
	public void servicesPointcut() {}

	@Before("servicesPointcut()")
	public void logBeforeService() {
    	System.out.println("   Log before Service");
    }

	@After("servicesPointcut()")
    public void logAfterService() {
    	System.out.println("   Log after Service");
    }
	
	@AfterThrowing("servicesPointcut()")
    public void logErrorService() {
    	System.out.println("   Log error Service");
    }

    // Log with parameters
	@Before("execution(* com.uciext.springfw.class04.courses.service.CourseService.getCourse(..)) and args(courseId)")
    public void logBeforeParam(JoinPoint joinpoint, String courseId) {
    	System.out.println("   Log before getCourse: courseId=" + courseId);
    }

	@AfterReturning(pointcut="execution(* com.uciext.springfw.class04.courses.service.CourseService.getCourse(..))", returning="course")
    public void logAfterParam(Course course) {
    	System.out.println("   Log after getCourse: " + course);
    }

	// Generic object argument
	@Before("execution(* com.uciext.springfw.class04.courses.service.*.*(..)) and args(object)")
	public void logBeforeParamObject(JoinPoint joinpoint, Object object) {
    	System.out.println("   Log before service: arg=" + object);
    }

	// Any argument
	@Before("execution(* com.uciext.springfw.class04.courses.service.*.*(..)) and args(..)")
	public void logBeforeAnyParam(JoinPoint joinpoint) {
    	System.out.println("   Log before service with any args");
    }

	// Log after exception
	@AfterThrowing("execution(* com.uciext.springfw.class04.courses.service.*.*(..))")
    public void logErrorParam(JoinPoint joinpoint) {
    	System.out.println("   Log after exception updateDepartment: in method=" + joinpoint.toString());
    }

    // Log around - execution time in milliseconds
	@Around("execution(* com.uciext.springfw.class04.courses.service.DepartmentService.*(..))")
    public void logAroundDuration(ProceedingJoinPoint joinpoint) {
        try { 
        	System.out.println("   Log before around");
            long start = System.currentTimeMillis(); 
            joinpoint.proceed(); 
            long end = System.currentTimeMillis(); 
            System.out.println("   Log after around: execution took " + (end-start) + " milliseconds");
        } 
        catch (Throwable t) { 
        	System.out.println("   Log Error in method: " + t.getMessage()); 
        } 
    }
}
