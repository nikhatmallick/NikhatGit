package com.uciext.springfw.class02.courses;

import java.util.Properties;
import org.apache.log4j.Logger;

public class CourseMessages {

    private static Logger logger = Logger.getLogger(CourseMessages.class.getName());

    private Properties messages;

    public Properties getMessages() {
    	return messages;
    }

    public String getMessage(String messageId) {
    	return (String)messages.get(messageId);
    }
    
    public void setMessages(Properties messages) {
    	this.messages = messages;
    }    
}
