package exam;

public class Grocery extends Item{

	public static double limit;
	
	public Grocery(int day, String description, double cost) {
		super(day, description, cost);
		try {
			setLimit(limit - cost);
		} catch(NegBExeption e) {
			System.out.println(e.eMessage);
		}
	}
	
	public static void setLimit(double limit) throws NegBExeption{
		if (limit < 0) {
			throw new NegBExeption();
		}
		Grocery.limit = limit;
	}
	
	public static void getLimit() {
		System.out.println(limit);
	}

}
