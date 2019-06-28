package exam;

public class MST {

	public static void main(String[] args) {
		try 
		{
			int x = 0;
			int y = 5/x;
			
		}
		catch (ArithmeticException ae)
		{
			System.out.println("Arithmetic exception");
		}
		catch (Exception e)  //if this was the first catch, it would not run due to compile error.
		{
			System.out.println("Exception");
			
		} 
		
	}
}
