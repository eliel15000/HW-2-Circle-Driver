// Eliezer Encarnacion
// Circle Class
// x, y, radius, getters, and setters


public class Circle {
	
	// variables
	private double x, y, radius;
	
	// circle
	public Circle() {
		setX(0);
		setY(0);
		setRadius(1);
	}
	
	public Circle(double x, double y, double radius) {
		setX(x);
		setY(y);
		setRadius(radius);
	}
	
	// getters
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getRadius() {
		return radius;
	}
	
	// setters
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setRadius(double radius) {
		if (radius > 0)
			this.radius = radius;
		else
			System.out.println("The radius must be positive");
	}
	
	// Area
	public double getArea() {
		return Math.PI * Math.pow(this.radius, 2);
	}
	
	// Perimeter
	public double getPerimeter() {
		return 2 * this.radius * Math.PI;
	}
	
	// Distance
	public double getDistance(Circle c2) {
		double sum, root;
		sum = Math.pow(c2.getX() - this.x, 2) + Math.pow(c2.getY() - this.y, 2);
		root = Math.sqrt(sum);
		return root;
	}
	
	// toString
	public String toString() {
		return "x = " + x + "   y = " + y + "   radius = " + radius;
	}
	
	// Contains Circle
	public boolean contains(Circle circle) {
		return (this.radius >= circle.radius && this.getDistance(circle) <= (this.radius - circle.radius) );
	}
	
	// Overlaps Circle
	public boolean overlaps(Circle circle ) {
		return (this.getDistance(circle) < (this.radius + circle.radius));
	}
	
	// Arbitrary point
	public boolean contains(double px, double py) {
		return ((Math.pow((Math.pow(px - this.x, 2) + Math.pow(py - this.y, 2)), 0.5)) < this.radius);
	}

}
