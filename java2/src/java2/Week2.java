package java2;

import java.util.Scanner;
import java.lang.*;
import java.util.*;

public class Week2 {
	 Scanner sc2 = new Scanner(System.in);
	
	 
     int circle1Radius = sc2.nextInt();
     int circle2Radius = sc2.nextInt();
    
     Circle2 obj3 = new Circle2(circle1Radius);
     Circle2 obj4 = new Circle2(circle2Radius);
    
     //Circle1 obj1 = new Circle1(circle1Radius);
    // Circle1 obj2 = new Circle1(circle2Radius);
     
     

}


/*abstract class GeometricObject{
	protected String color;
	protected double weight;
	
	protected GeometricObject(String color, double weight) {
		this.color = color;
		this.weight = weight;
	}
	
	protected GeometricObject() {
		this.color = "white";
		this.weight = 1.0;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public abstract double findArea();
	public abstract double findPerimeter();			
}//end abstract class geometricObject

class Circle1 extends GeometricObject implements Comparable<Circle1> {
	protected double radius;
	
	protected Circle1() {
		this(1.0,"white",1.0);
	}
	
	protected Circle1(double radius, String color, double weight) {
		super("white", weight);
		this.radius = radius;
	}
	
	protected Circle1(double radius) {
		super("white",1.0);
		this.radius = radius;
	}
	public double findArea()
	{
		return 2*radius*radius*Math.PI;
	}
	public double findPerimeter() {
		return 2* radius* Math.PI;
	}

	
	public int acompareTo1(Object o) {
		// TODO Auto-generated method stub
		if(this.findArea() > ((Circle1)o).findArea())
		return (int)this.radius;
		else return (int) ((Circle1)o).radius;
	}

	@Override
	public int compareTo(Circle1 o) {
		// TODO Auto-generated method stub
		if(this.findArea() > o.findArea())
			return (int)this.radius;
		else return (int)o.radius;
		
	}

	

	
}*/

