package revision;

import java.io.IOException;

public class SuperClass {
	public void start() throws IOException{
		throw new IOException("Not able to open file");
	}
	
	public static void main(String[] args) {
		SubClass a = new SubClass();
		try {
			a.test();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		try {
		a.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}

class SubClass extends SuperClass{
	public void test() throws IOException{
		throw new IOException("Not able to start");
	}
}