package com.uciext.springfw.class04.common;

public class Util {

    public static void waitMS(long ms) {
    	try {
    		Thread.sleep(ms);
    	}
    	catch (Exception e) {}
    }

}
