package week5;

public class Photograph {

	private String title;
	private String date;
	public Photograph(String title, String date) {
		this.title = title;
		this.date = date;
	}
	
	public void changeTitle(String newT) {
		title = newT;
	}
}
