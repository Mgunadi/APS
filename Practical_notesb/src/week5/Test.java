package week5;

public class Test {

	
	public static void main(String[] args) {

	//Example1();
	//Example2();
	//Example3();
		Tute5();
		String str = ""; //different from null
		System.out.println(str.length()); // 
	}
	
	
	public void Example1() {
		A ref = new A() {
			//override method 1 inside anonymous class
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
		A a = new A() {

			@Override
			public void method1() {
				System.out.println("Hello1");
				
			}

			@Override
			public void method2() {
				System.out.println("Hellow2");
				
			}
		};
		a.method1();
		a.method2();
	}
	
	
	public static void Example3() {
		
		// ref is a reference which refers to an object of
		// an anonymous class which implements interface C
		
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
		Radio r = new Radio();
		r.switch1();
		Computer c = new Computer(new Mac("iphone"));
		c.switch1();
		c.printBrand();
	}
	
}
