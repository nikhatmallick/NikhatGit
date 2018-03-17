package com.uciext.springfw.class02.courses.model;

import java.lang.StringBuilder;
import org.apache.log4j.Logger;

public class Instructor {

    private static Logger logger = Logger.getLogger(Instructor.class.getName());

	// Properties
    private String firstName;
    private String lastName;

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String value) {
        this.lastName = value;
    }

    public String toString() {
       StringBuilder buff = new StringBuilder("[Instructor: ")
       .append("firstName=").append(firstName)
       .append(", lastName=").append(lastName)
       .append("]")
       ;

       return buff.toString();
    }

    public String print() {
        return firstName + " " + lastName;
    }
}
