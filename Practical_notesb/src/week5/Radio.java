package week5;

public class Radio {
	private boolean state; 
	
	
	public void changeStation() {
		
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
