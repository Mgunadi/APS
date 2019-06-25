package exam;

public class Prize {

	public static int prizeCount = 0;
	private String itemName;
	private String recipient;
	
	public Prize(String item, String name) {
		itemName = item;
		recipient = name;
		prizeCount++;
	}
	
	public static int getPrizeCount() {
		return prizeCount;
	}
	
	public void print() {
		System.out.println("Contestant " + recipient + "has won a " + itemName);
		System.out.println("A total of " + prizeCount + "prizes have been given away!!!");
	}	
	
	public static void main(String[] args) {
		Prize p1 = new Prize("Movie Tickets", "Bob");
		System.out.println("Prizes so far: " + p1.getPrizeCount());
		
		Prize p2 = new Prize("A NEW CAR!!!", "Jane");
		p2.print();
	}
	
}

class PersonTest {

}
