package com.uciext.springfw.class04.courses.events;

import org.springframework.context.ApplicationEvent;

import com.uciext.springfw.class04.courses.model.Department;

public class DepartmentUpdatedEvent extends ApplicationEvent {
    private Department department;

	public DepartmentUpdatedEvent(Object source, Department department) { 
	    super(source); 
	    this.department = department;
	} 

	public Department getEventData() {
	    return department;
	}
}
