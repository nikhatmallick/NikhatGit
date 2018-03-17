package com.abc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.rest.client.DepartmentClient;
import com.abc.rest.model.Department;
import com.abc.rest.model.DepartmentList;

public class RegistrationClientApp {

    public static void main(String[] args) throws Exception {
        RegistrationClientApp app = new RegistrationClientApp();
        app.run();
    }
    
    public void run() {
    	ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("/META-INF/spring/RegistrationClientContext.xml");
        DepartmentClient client = (DepartmentClient) context.getBean("departmentClient");

        // Get departments
    	System.out.println("\n==== Get Departments ...");
    	ArrayList<Department> departments = client.getDepartments();
    	System.out.println("---- Total departments=" + departments.size());
    	for (int i=0; i<departments.size(); i++) {
    	    System.out.println("dept[" + i + "]=" + departments.get(i));	
    	}

    	// Get departments by id
    	System.out.println("\n==== Get Departments by Id ...");
       	System.out.println("----   [id=" + departments.get(0).getDepartmentId() + "] " 
       			+ client.getDepartment(departments.get(0).getDepartmentId()));
       	System.out.println("----   [id=" + departments.get(1).getDepartmentId() + "] " 
       			+ client.getDepartment(departments.get(1).getDepartmentId()));

       	// Add a new department
    	System.out.println("\n==== Add new Department ...");
    	Department dept = new Department();
    	dept.setDepartmentName("Finance");
    	client.createDepartment(dept);

    	departments = client.getDepartments();
    	for (int i=0; i<departments.size(); i++) {
    	    System.out.println("dept[" + i + "]=" + departments.get(i));
    	    if ("Finance".equals(departments.get(i).getDepartmentName()))
    	    	dept = departments.get(i);
    	}
       	
       	// Update a department
    	System.out.println("\n==== Update a Department ...");
//    	dept = departments.get(departments.size()-1);
    	dept.setDepartmentName(dept.getDepartmentName() + "-2");
    	client.updateDepartment(dept);

    	departments = client.getDepartments();
    	for (int i=0; i<departments.size(); i++) {
    	    System.out.println("dept[" + i + "]=" + departments.get(i));	
    	}

       	// Delete a department
    	System.out.println("\n==== Delete a Department ...");
//    	dept = departments.get(departments.size()-1);
    	client.deleteDepartment(dept);

    	departments = client.getDepartments();
    	for (int i=0; i<departments.size(); i++) {
    	    System.out.println("dept[" + i + "]=" + departments.get(i));	
    	}
    }
}
