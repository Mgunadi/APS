package week3;

public class SportCar extends Car{
	private int horsePower;
	
	private static final int DISCOUNT_THRESHOLD = 400;
	private static final double HIGH_POWER_RATE = 0.05;
	private static final double LOW_POWER_RATE = 0.1;
	
	
	public SportCar(int maxSpeed, double regularPrice, String color, int horsePower) {
		super(maxSpeed, regularPrice, color);
		this.horsePower = horsePower;
	}
	
	@Override
	public double getSalePrice(){
		if (horsePower > DISCOUNT_THRESHOLD) {
			return getRegularPrice() * (1- HIGH_POWER_RATE); 
		} else {
			return getRegularPrice() * (1- LOW_POWER_RATE);
		}
	}
}
