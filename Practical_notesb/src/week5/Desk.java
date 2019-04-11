package week5;

public class Desk {

	private boolean isTidy;
	private Drawer d;
	private Radio r;
	private Computer c;
	private Photograph p;
	
	public Desk(Drawer d, Radio r, Computer c, Photograph p) {
		this.d = d;
		this.r = r;
		this.c = c;
		this.p = p;
	}
	
	public void tidyUp() {
		isTidy = true;
	}
	
	public void printDetail() {
		
	}
	
}
