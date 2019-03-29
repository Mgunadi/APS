package week3;

public class Wagon extends Car {
	
	private double length;

	public Wagon(int maxSpeed, double regularPrice, String color, double length) {
		super(maxSpeed, regularPrice, color);
		this.length = length;
	}

	@Override
	public double getSalePrice() {
		if (length < 5) return super.getSalePrice() * 0.95;
		else return getRegularPrice() * 0.90;
	}
	
}
