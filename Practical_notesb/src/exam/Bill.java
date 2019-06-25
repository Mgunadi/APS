package exam;

public class Bill extends Item {
	private String company = "unknown";
	public Bill(int day, String description, double cost) {
		super(day, description, cost);
	}
	
	public Bill(int day, String description, double cost, String company) {
		this(day, description, cost);
		this.company = company;
	}

}
 