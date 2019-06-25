package exam;

public class TestItem {


	public static void main(String[] args) {
		Item[] list = new Item[5];
		try {
			Grocery.setLimit(100.00);
		} catch (NegBExeption e) {
			e.printStackTrace();
		}
		Grocery.getLimit();
		//list[0] = new Bill(1, "Phone Bill", 80.99);
		//list[1] = new Stationery(2, "Printer", 200);
		list[0] = new Grocery(3, "Milk and Bread", 20);
		//list[3] = new Stationery(3, "USB Key", 40);
		list[1] = new Grocery(3, "USB Key", 120);		
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof Bill) {
				System.out.println(((Bill)list[i]).getCost());
			} else if (list[i] instanceof Stationery) {
				System.out.println(((Stationery)list[i]).getCost());
			} else if (list[i] instanceof Grocery) {
				System.out.println(((Grocery)list[i]).getCost());
			}
		}
		
		Grocery.getLimit();
		
	}

}
