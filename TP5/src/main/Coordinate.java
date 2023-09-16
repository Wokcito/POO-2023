package tp_05;

public class Coordinate {

	private Number x;
	private Number y;
	
	// Constructors
	public Coordinate(Number x, Number y) {
		this.x = x;
		this.y = y;
	}
	
	// Methods
	public String toString() {
		return "{ " + this.x + ", " + this.y + " }";
	}
	
}
