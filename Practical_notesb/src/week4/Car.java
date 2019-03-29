package week4;

public class Car extends Vehicle{
	private static String name;
	private static int numSold;
	
	public Car(String name, double price) {
		super(price);
		this.name = name;
	}
	
	public double sell(int quantity) {
		numSold += quantity;
		return get.Price * quantity;
	}
	
	public static int getNumSold(){
		System.out.println("The sold car is " + name);
	return numSold;
	
	
	
	
}
