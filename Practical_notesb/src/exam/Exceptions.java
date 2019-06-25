package exam;

public class Exceptions {

	public static void main(String[] args) {
		try { 
			myMethod1();
			System.out.println("Method 1 done.");
			myMethod2();
			System.out.println("Method 2 done.");
		} catch (MyOwnException e) {
			System.out.println("My Eception!");
		} catch (Exception e) {
			System.out.println("Top level Exception!");
		} finally {
			System.out.println("What now?!");
		}
		System.out.println("did we crash?");

	}

		public static void myMethod1() throws MyOwnException {
			//throw new MyOwnException();
		}
		
		public static void myMethod2() throws SomeOtherException {
			throw new SomeOtherException();
		}
}
