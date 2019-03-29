package week3;

public class MyAutoShop {

	public static void main(String[] args) {
		Wagon Billy = new Wagon(30, 80, "brown", 8);
		
		FordCar Joey = new FordCar(150, 20000, "red", 2019, 0.20);
		FordCar John = new FordCar(140, 20000, "blue", 2017, 0.20);
		
		SportCar Huey = new SportCar(200, 40000, "green", 200);
		
		System.out.println("Billy is: " + Billy.getSalePrice());
		System.out.println("Joey is: " + Joey.getSalePrice());
		System.out.println("Huey is: " + Huey.getSalePrice());
	}

}
