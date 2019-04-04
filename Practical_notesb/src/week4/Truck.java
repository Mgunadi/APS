package week4;

class Truck extends Vehicle {
	private static double taxRate = 0.2;
	public int quantity;
	
	public Truck(double price) {
		super(price);
		quantity = 0;
	}

	public static void setTaxRate(double newRate) {
		taxRate = newRate;
	}
	
	public double sell(int quantity) {
		this.quantity = quantity;
		return getPrice() * quantity * (1 + taxRate);
	}
}