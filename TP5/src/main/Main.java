package tp_05;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle rectangle1 = new Rectangle("Rectangle1", "blue", new Coordinate(1, 2), 3.0, 2.1);
		Rectangle rectangle2 = new Rectangle("Rectangle2", "green", new Coordinate(3, 4), 6.0, 1.15);
		Square square1 = new Square("Square1", "yellow", new Coordinate(2, 6), 3.76);
		Elipse elipse1 = new Elipse("Elipse1", "pink", new Coordinate(1, 10), 20.0, 12.10);
		
		List<Shape> shapeList = new ArrayList<Shape>();
		
		shapeList.add(rectangle1);
		shapeList.add(rectangle2);
		shapeList.add(square1);
		shapeList.add(elipse1);
		
		for (Shape sh : shapeList) {
			System.out.println(sh.toString());
			System.out.println(sh.getArea());
			System.out.println(sh.getPerimeter());
		}
	}
}
