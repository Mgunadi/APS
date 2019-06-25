package exam;

public class Item {

	private int day;
	private String description;
	private double cost;
	
	public Item(int day, String description, double cost) {
		this.day = day;
		this.description = description;
		this.cost = cost;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
