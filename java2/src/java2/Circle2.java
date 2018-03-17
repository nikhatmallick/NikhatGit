package java2;

import java.util.*;
import java.lang.*;

public class Circle2 extends GeometricObject1 implements Comparable<Circle2> {
	protected double radius;
	
	public Circle2() {
		this(1.0,"white",1.0);
	}
	
	public Circle2(double radius, String color, double weight) {
		super("white", weight);
		this.radius = radius;
	}
	
	public Circle2(double radius) {
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
		if(this.findArea() > ((Circle2)o).findArea())
		return (int)this.radius;
		else return (int) ((Circle2)o).radius;
	}

	@Override
	public int compareTo(Circle2 o) {
		// TODO Auto-generated method stub
		/*if(this.findArea() > o.findArea())
			return (int)this.radius;
		else return (int)o.radius;*/
		return (int)Math.max(this.radius, o.radius);
		
	}

}
