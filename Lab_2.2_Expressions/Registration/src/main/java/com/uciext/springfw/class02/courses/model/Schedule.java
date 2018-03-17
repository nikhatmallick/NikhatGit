package com.uciext.springfw.class02.courses.model;

import org.apache.log4j.Logger;

public class Schedule {

    private static Logger logger = Logger.getLogger(Schedule.class.getName());

	// Properties
    private int year;
    private int quarter;

    // Getters and Setters
    public int getYear() {
        return year;
    }
    public void setYear(int value) {
        this.year = value;
    }

    public int getQuarter() {
        return quarter;
    }
    public void setQuarter(int value) {
        this.quarter = value;
    }

    public String toString() {
       StringBuilder buff = new StringBuilder("[Schedule: ")
       .append("year=").append(year)
       .append(", quarter=").append(quarter)
       .append("]")
       ;

       return buff.toString();
    }
}
