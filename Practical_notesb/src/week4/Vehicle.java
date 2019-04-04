package week4;

public abstract class Vehicle {
	
	private double price;
	private int quantity; 
	
	public Vehicle(double price) { // price in K
		this.price = price * 1000;
	}
	
	public double getPrice() {
		return price;
	}
	
	abstract public double sell(int quantity);
	
}
