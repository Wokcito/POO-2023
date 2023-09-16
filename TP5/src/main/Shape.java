package tp_05;

public class Shape {

	private String name;
	private String color;
	private Coordinate coords;
	
	
	// Constructors
	public Shape(String name, String color, Coordinate coords) {
		this.name = name;
		this.color = color;
		this.coords = coords;
	}
	
	// Methods
	public String toString() {
		return "name: " + this.name + ", color: " + this.color + ", coords: " + this.coords;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String newColor) {
		this.color = newColor;
	}
	
	public Coordinate getCoords() {
		return this.coords;
	}
	
	public void setCoords(Coordinate newCoords) {
		this.coords = newCoords;
	}
	
	public Double getArea() {
		return 0.0;
	}

	public Double getPerimeter() {
		return 0.0;
	}
}
