package week5;

public class Radio implements Switch {
	private boolean state; 
	private String station;
	
	public Radio(String s) {
		station = s;
	}
	public void changeStation(String s) {
		station = s;
	}
	
	public void switch1() {
		if (state == false) {
			state = true;
			System.out.println("Radio is now on");
		} else {
			state = false;
			System.out.println("Radio is now off.");
		}

	}

}
