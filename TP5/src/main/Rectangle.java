package tp_05;

public class Rectangle extends Shape {

	private Double shortSide;
	private Double longSide;
	
	// Constructors
	public Rectangle(String name, String color, Coordinate coords, Double shortSide, Double longSide) {
		super(name, color, coords);
	
		this.shortSide = shortSide;
		this.longSide = longSide;
	}
		
	// Methods
	@Override
	public String toString() {
		String shapeString = super.toString();
		return shapeString + ", Short Side: " + shortSide + ", Long Side: " + longSide;
		
	}
	
	@Override
	public Double getArea() {
		return this.shortSide * this.longSide;
	}
	
	public Double getPerimeter() {
		return (2 * (this.shortSide + this.longSide));
	}
	
	public void changeSize(Float scaleFactor) {
		this.shortSide = this.shortSide * scaleFactor;
		this.longSide = this.longSide * scaleFactor;
	}
	
	
	
}
