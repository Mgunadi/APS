package week5;

public class Test {

	
	public static void main(String[] args) {

		//Example1();
		//Example2();
		//Example3();
		//Tute5();
		Composition();
		
		String str = ""; //different from null
		System.out.println(str.length()); // 
	}
	
	
	public void Example1() {
		A ref = new A() {
			//anonymous class always extends a superclass (A)
			//override method 1 inside A class
			public void method1() {
				System.out.println("method1() from anonymous class");
			}
		};
		
		ref.method1();
		
	}
	
	public static void Example2() {
		// can create an anonymous class which extends an abstract
		// class but we need to provide implementation for all
		// abstract methods defined in the abstract class
		B b = new B() {

			@Override
			public void method1() {
				System.out.println("Hello1");
				
			}

			@Override
			public void method2() {
				System.out.println("Hello2");
				
			}
		};
		b.method1();
		b.method2();
	}
	
	
	public static void Example3() {
		
		// ref is a reference which refers to an object of
		// an anonymous class which implements interface C.
		// Anon class must be labelled with the interface name.
		
		C ref = new C() {
			@Override
			public void method1() {
				System.out.println("method1() from anonymous class");
				
			}
			@Override
			public void method2() {
				System.out.println("method2() from anonymous class");
			}
		};
		
		ref.method1();
		ref.method2();
		
	}
	
	public static void Tute5() {
		Radio r = new Radio("FM");
		r.switch1();
		Computer c = new Computer(new Mac("iphone"));
		c.switch1();
		c.printBrand();
	}
	
	public static void Composition() {
		Radio Sony = new Radio("AM1030");
		Computer MAC_G4 = new Computer(new Mac("G4"));
		MAC_G4.switch1();
		Paper Java_notes = new Paper("Sysout");
		Drawer d1 = new Drawer(Java_notes);
		d1.close();
		Photograph myself = new Photograph("My_selfie", "29/07/1991");
		Desk myDesk = new Desk(d1, Sony, MAC_G4, myself);
	}
	
}
