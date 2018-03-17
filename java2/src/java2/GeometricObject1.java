package java2;


public abstract class GeometricObject1{
	protected String color;
	protected double weight;
	
	public GeometricObject1(String color, double weight) {
		this.color = color;
		this.weight = weight;
	}
	
	public GeometricObject1() {
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
