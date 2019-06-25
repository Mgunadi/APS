package exam;

import java.util.ArrayList;

public abstract class Shape {
	
	public abstract void draw();
	
	public static void mai(String[] args) {
		ArrayList shapes = new ArrayList();
		shapes.add(new Square());
		((Square)shapes.get(0)).draw();
	}
}

class Square extends Shape {
	public void draw() {
		System.out.println("The Square is being drawn.");
	}
}