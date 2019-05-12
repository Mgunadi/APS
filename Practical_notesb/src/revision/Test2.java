package revision;

import java.io.IOException;
class Father {
	String name = "Joe";
	public Father(String name) throws IOException {
		System. out .print( "Father " );
		this.name = name.concat("s"); //changing instance variables means you have to add a super constructor in inherited classes.
		System.out.println(this.name);
		throw new IOException();
	}
	public Father() throws IOException {
		System.out.println(this.name);
		throw new IOException();
	}
}

class Son extends Father {
	public Son(String name) throws IOException {
		super(name);
		System. out .print( "Son " );
	}
	public Son() throws IOException  {
		System. out .print( "Son " );
	}
}

public class Test2 {
	public static void main(String[] args ) {
		try {
			//new Son("Matt");
			new Son();
		} catch (IOException e ) {
			System. out .print( "Inside catch" );
		}
	}
}