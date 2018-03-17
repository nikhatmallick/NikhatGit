package java2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Week3 {
    public static void main(String args[] ) throws Exception {
        //TODO: Correct the errors in the program
        
        List<GenericsLab> list = new ArrayList<GenericsLab>();
		
		GenericsLab integerItem = new GenericsLab(100); 
        GenericsLab stringItem = new GenericsLab("UC Irvine Java Programming"); 
		
		list.add(integerItem);
	    list.add(stringItem);
	    list.add(new GenericsLab("An item in the collection"));
	    
        //TODO: Write a for loop to print out the elements of the "list" array
	  //  System.out.println(integerItem.getItem());
	   System.out.println(integerItem.getItemType()); 
	   System.out.println(stringItem.getItemType()); 
	 
    }
}

//TODO: Correct the errors in the GenericsLab class
class GenericsLab<Object> {
	Object item; 
		    
	GenericsLab(Object item) {  
		this.item = item;  
	}  
		  
	Object getItem() {  
	    return item;  
	}  
	
	String getItemType() {  
	   return item.getClass().getName();  
	}	
}
