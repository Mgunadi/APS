package week3;

public class FordCar extends Car{

	private int year;
	private double manufacturerDiscount;
	
	private static final double DISCOUNT_RATE = 0.03;
	
	public FordCar(int maxSpeed, double regularPrice, String color, int year, double manufacturerDiscount) {
		super(maxSpeed, regularPrice, color);
		this.year = year;
		this.manufacturerDiscount = (year > 1)? getRegularPrice() * DISCOUNT_RATE : 0;
	}
	
	@Override
	public double getSalePrice() {
		return getRegularPrice() - manufacturerDiscount; 
	}
	
	
}
