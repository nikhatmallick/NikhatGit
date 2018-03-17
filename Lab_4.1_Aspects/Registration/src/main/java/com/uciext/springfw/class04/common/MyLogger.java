package com.uciext.springfw.class04.common;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.uciext.springfw.class04.courses.model.Course;

public class MyLogger {

	// Generic log methods
	public void logBefore() {
    	System.out.println("   Log before");
    }

    public void logAfter() {
    	System.out.println("   Log after");
    }
	
    public void logError() {
    	System.out.println("   Log error");
    }

	// Log department 
    public void logBeforeDepartment() {
    	System.out.println("   Log before Department");
    }

    public void logAfterDepartment() {
    	System.out.println("   Log after Department");
    }
	
    public void logErrorDepartment() {
    	System.out.println("   Log error Department");
    }

    // Log services
    public void logBeforeService() {
    	System.out.println("   Log before Service");
    }

    public void logAfterService() {
    	System.out.println("   Log after Service");
    }
	
    public void logErrorService() {
    	System.out.println("   Log error Service");
    }

    // Log with parameters
    public void logBeforeParam(JoinPoint joinpoint, String courseId) {
    	System.out.println("   Log before getCourse: courseId=" + courseId);
    }

    public void logAfterParam(JoinPoint joinpoint, Course course) {
    	System.out.println("   Log after getCourse: " + course);
    }
	
    public void logErrorParam(JoinPoint joinpoint, Exception ex) {
    	System.out.println("   Log error Param: " + ex.getMessage());
    }

    public void logAfterParamObject(JoinPoint joinpoint, Object object) {
    	System.out.println("   Log after get returned: " + object);
    }
	
    // Log around - execution time in milliseconds
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
