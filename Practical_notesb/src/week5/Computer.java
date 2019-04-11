package week5;

public class Computer implements Switch{

	private boolean state = false;
	private String brand;
	
	public Computer(Mac m) {
		brand = m.getBrand();
	}
	
	public Computer(PC pc) {
		brand =pc.getBrand();
	}
	
	@Override
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
