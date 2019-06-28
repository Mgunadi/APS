package exam;

public class Stationery extends Item implements TaxDeduction{

	public Stationery(int day, String description, double cost) {
		super(day, description, cost);

	}
	
	@Override
	public double deduct() {
		return 0.25 * getCost();
	}

}
