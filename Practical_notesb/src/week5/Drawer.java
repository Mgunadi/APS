package week5;

public class Drawer {

	private Paper p;
	private boolean isOpen;
	
	public Drawer(Paper p) {
		this.p = p;
	}
	
	public Drawer() {
		this.p = null;
	}
	
	public void fill(Paper p) {
		this.p = p;
	}
	
	public void empty() {
		this.p = null;
	}
	
	public void openUp(){
		isOpen = true;
	}
	
	public void close() {
		isOpen = false;
	}
	
}
