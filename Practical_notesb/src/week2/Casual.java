package week2;

public class Casual {

	private String ID;
	private String name;
	private double h_rate = 0;
	private double hours;
	private double salary;
	
	
	public Casual(String ID, String name, double h_rate, double hours, double salary) {
		this.ID = ID;
		this.name = name;
		this.h_rate = h_rate;
		this.hours = hours;
		this.salary = salary;
	}
	
	public Casual(String ID, String name, double h_rate) {
		this.ID = ID;
		this.name = name;
		this.h_rate = h_rate;
		this.hours = 0;
		this.salary = 1000;
	}

	public boolean addHour(double h) {
		hours += h;
		salary += hours * h_rate;
		return true;
	}
	
	public boolean changeRate(double r) {
		if ((r > -10 ) && (r < 10)) {
			h_rate += (0.1 * h_rate);
			hours = 0;
			return true;
		} else {
			return false;
		}
	}
	
	public double calcSalary() {
		return salary;
	}
	
	public double getRate() {
		return h_rate;
	}
	
	public String getName() {
		return name ;
	}
	
}
