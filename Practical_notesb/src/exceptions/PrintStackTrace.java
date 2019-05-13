package exceptions;
import java.io.IOException;

public class PrintStackTrace {
	public static void test() throws IOException{
		System.out.println("RMIT AP tute/lab Java Exception session");
		throw new IOException();
	}
	
	public static void main(String args[]) {
		try{
			test();
		} catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}
