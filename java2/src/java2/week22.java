package java2;

import java.util.Scanner;

public class week22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc5 = new Scanner(System.in);
		sc5.useDelimiter("[,\n,\\s]");
		int c1rad = sc5.nextInt();
		
		int c2rad = sc5.nextInt();
		sc5.close();
		System.out.println("r1: " + c1rad);
		System.out.println("r2: " + c2rad);
		Circle2 obj1 = new Circle2((double)c1rad);
		Circle2 obj2 = new Circle2((double)c2rad);
		obj1.compareTo(obj2);
		System.out.println("calling compareto: " + (double)obj1.compareTo(obj2));

	}

}
/*kesha implemenatation
 * public class GeometricObjectComparable {
  // Main method
  public static void main(String[] args) {
    java.util.Scanner sc=new java.util.Scanner(System.in);
    sc.useDelimiter("[,\n]");
  
    int circle1Radius = sc.nextInt();
    int circle2Radius = sc.nextInt();
    
    // Create two comparable circles
    Circle1 circle1 = new Circle1(circle1Radius);
    Circle1 circle2 = new Circle1(circle2Radius);

    // Display the max circle
    Circle1 circle = (Circle1)GeometricObject1.max(circle1, circle2);
    System.out.println(circle.getRadius());
  }
}

abstract class GeometricObject1 implements Comparable {
  protected String color;
  protected double weight;

  // Default construct
  protected GeometricObject1() {
    color = "white";
    weight = 1.0;
  }

  // Construct a geometric object
  protected GeometricObject1(String color, double weight) {
    this.color = color;
    this.weight = weight;
  }

  // Getter method for color
  public String getColor() {
    return color;
  }

  // Setter method for color
  public void setColor(String color) {
    this.color = color;
  }

  // Getter method for weight
  public double getWeight() {
    return weight;
  }

  // Setter method for weight
  public void setWeight(double weight) {
    this.weight = weight;
  }

  // Abstract method
  public abstract double findArea();

  // Abstract method
  public abstract double findPerimeter();
  
  
  public static Comparable max(Comparable o1, Comparable o2) {
    if (o1.compareTo(o2) > 0)
      return o1;
    else
      return o2;
  }
}

// Circle.java: The circle class that extends GeometricObject
class Circle1 extends GeometricObject1 { 
  protected double radius;

  // Default constructor
  public Circle1() {
    this(1.0, "white", 1.0);
  }

  // Construct circle with specified radius
  public Circle1(double radius) {
    super("white", 1.0);
    this.radius = radius;
  }

  // Construct a circle with specified radius, weight, and color
  public Circle1(double radius, String color, double weight) {
    super(color, weight);
    this.radius = radius;
  }

  // Getter method for radius
  public double getRadius() {
    return radius;
  }

  // Setter method for radius
  public void setRadius(double radius) {
    this.radius = radius;
  }

  // Implement the findArea method defined in GeometricObject
  public double findArea() {
    return radius*radius*Math.PI;
  }

  // Implement the findPerimeter method defined in GeometricObject
  public double findPerimeter() {
    return 2*radius*Math.PI;
  }

  // Override the equals() method defined in the Object class
  public boolean equals(Circle1 circle) {
    return this.radius == circle.getRadius();
  }

  // Implement the compareTo method defined in Comparable
  public int compareTo(Object o) {
    if (getRadius() > ((Circle1)o).getRadius())
      return 1;
    else if (getRadius() < ((Circle1)o).getRadius())
      return -1;
    else
      return 0;
  }
}

 */
