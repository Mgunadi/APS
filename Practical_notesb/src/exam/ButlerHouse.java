package exam;

public class ButlerHouse {
	
	public class Twin {
		private String name = "Scott";
		public Twin() {
			
		}
		
		public String motto() {
			System.out.println("In the year ");
			getYear(); //calls an outerclass method as well before continuing.
			return "Work sucks";  //not accessible to the outside world i.e users
		}
	}
	
	
	public static class HouseFeatures {
		private static String nameDerriv = "Boutlier";
		private int generation = 18;
		
		public void sigil() {
			System.out.println("The " + nameDerriv + "stands proud.");
			System.out.println("We are standing strong until today,");
			// getYear();  illegal to access outer class, which is non static.
		}
		
		public void howManyPeople() {
			System.out.println("In this generation, " + generation + ", there are " + noPeople + " people");
		}
		
		private static String getName() {
			return nameDerriv;
		}
	}
	
	
	public static int noPeople = 4;
	public int year;
	public Twin Scott;
	public HouseFeatures ButlerTrivia;
	
	public ButlerHouse(int year) {
		this.year = year;
		Scott =  new Twin();
		ButlerTrivia = new HouseFeatures();
	}	
	
	public void getScottmotto() {
		System.out.println(Scott.motto()); 
	}
	
	public void getYear() {
		System.out.println(year);
	}

	public void getHouseName() {
		System.out.println(HouseFeatures.getName()); //when accessing a static inner clas' static method, no need to instantiate the inner class.
	}
	public void getGenInfo() {
		ButlerTrivia.howManyPeople();  //accessing a static inner class' non-static method: must instantiate
	}
	
	public static void main(String[] args) {
		ButlerHouse recent = new ButlerHouse(2018);
		recent.getYear();
		recent.getScottmotto();
		//recent.Scott.motto(); //this does not work. 
		recent.getGenInfo();
		recent.getHouseName();
		
		ButlerHouse ancient = new ButlerHouse(1450);
		//Create an instance and access a public inner non-static class' non-static method.
		ButlerHouse.Twin Craig = ancient.new Twin();
		Craig.motto();
		
		
	}
	
}
