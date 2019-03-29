package week3;

public class Car {

	private int maxSpeed;
	private double regularPrice;
	private String color;
	
	private static final double DISCOUNT_RATE = 0.04;
	
	public Car(int maxSpeed, double regularPrice, String color){
		this.maxSpeed = maxSpeed;
		this.regularPrice = regularPrice;
		this.color = color;
	}
	
	public double getSalePrice() {
		return regularPrice * (1- DISCOUNT_RATE); 
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public double getRegularPrice() {
		return regularPrice;
	}

	public String getColor() {
		return color;
	}

	
	

	


}
