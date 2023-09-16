package tp_05;

public class Elipse extends Shape {
	
	private Double minusRadio;
	private Double majorRadio;
	
	// Constructors
	public Elipse(String name, String color, Coordinate coords, Double minusRadio, Double majorRadio) {
		super(name, color, coords);
		
		this.minusRadio = minusRadio;
		this.majorRadio = majorRadio;
	}
	
	// Methods
	public Double getArea() {
		return Math.PI * this.majorRadio * this.minusRadio;
	}
}
