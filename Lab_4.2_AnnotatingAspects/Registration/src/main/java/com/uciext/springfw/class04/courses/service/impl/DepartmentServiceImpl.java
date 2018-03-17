package com.uciext.springfw.class04.courses.service.impl;

import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.uciext.springfw.class04.common.Util;
import com.uciext.springfw.class04.courses.events.DepartmentUpdatedEvent;
import com.uciext.springfw.class04.courses.model.Course;
import com.uciext.springfw.class04.courses.model.Department;
import com.uciext.springfw.class04.courses.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService, ApplicationEventPublisherAware {

    private static Logger logger = Logger.getLogger(DepartmentService.class.getName());

    private Map<String, Department> departmentMap;

    @Autowired
    private ApplicationEventPublisher publisher; 
    
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) { 
        this.publisher = publisher; 
    } 
        
	public void setDepartments(Map<String, Department> departmentMap) {
		this.departmentMap = departmentMap;
	}

    @Override
	public Department getDepartment(String departmentId) {
		System.out.println("--- In DepartmentServiceImpl.getDepartment()");
		Util.waitMS(2000);
		return departmentMap.get(departmentId);
	}
	
    @Override
	public Map<String, Department> getDepartments() {
		System.out.println("--- In DepartmentServiceImpl.getDepartments()");
		Util.waitMS(1500);
		return (Map<String, Department>)departmentMap;
	}
	
    public void updateDepartment(String departmentId, String deptName) {
		System.out.println("--- In DepartmentServiceImpl.updateDepartment()");
		Util.waitMS(2500);
        Department department = departmentMap.get(departmentId);
        department.setDeptName(deptName);
        publisher.publishEvent(new DepartmentUpdatedEvent(this, department)); 
    }
}
