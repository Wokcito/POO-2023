package tp_05;

public class Circle extends Elipse {
	
	private Double radio;
	
	// Constructors
	public Circle(String name, String color, Coordinate coords, Double radio) {
		super(name, color, coords, radio, radio);
		
		this.radio = radio;
	}
	
	// Methods
	@Override
	public Double getArea() {
		return Math.PI * this.radio;
	}
}
