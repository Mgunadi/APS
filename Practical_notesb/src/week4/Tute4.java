package week4;

public class Tute4 {
	
	
	public static void main(String[] args) {
		Vehicle[] list = new Vehicle[4];
		list[0] = new Car("Corolla", 20);
		list[1] = new Truck(50);
		list[2] = new Car("BMW", 40);
		list[3] = new Truck(100);
		
		int[] sold = { 5, 4, 3, 1 };
		
		double total = 0;
		
		for (int i = 0; i < 4; i++) {
			System.out.println("The total amount is " + total); 
			
			total += list[i].sell(sold[i]);
			if (list[i] instanceof Car) {
				System.out.println("Cars sold so far:" + ((Car)list[i]).getNumSold());
			}
		}
		
		System.out.println("The total amount is " + total); 
	}
	
}