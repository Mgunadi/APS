package week5;

public class Computer {

	private boolean state;
	private String brand;
	
	public Computer(Mac m) {
		brand = m.getBrand();
	}
	
	
	public void switch1() {
		if (state == false) {
			state = true;
			System.out.println("Computer is now on");
		} else {
			state = false;
			System.out.println("Computer is now off.");
		}

	}
	
	public void printBrand() {
		System.out.println(brand);
	}
	

}
