package week8;
import java.io.*;

public class TestSerializable {
	public static void main(String arg[]) {

		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("myObject"));


			MyClass first = new MyClass(1, 2);
			MyClass second = new MyClass(3, 4);

			output.writeObject(first);
			output.writeObject(second);

			output.close();
			System.out.println("Objects sent to file.\n");
		} catch (IOException e) {
			System.out.println("Error in file handling");
		}

		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("myObject"));

			MyClass first = (MyClass) input.readObject();
			MyClass second = (MyClass) input.readObject();
			
			System.out.println("Reading the objects:");

			System.out.println(first.getOne() + " and " + first.getTwo());
			System.out.println(second.getOne() + " and " + second.getTwo());

			input.close();
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (IOException e2) {
			System.out.println(e2);
		}
	}
}

class MyClass implements Serializable {
	private int one;
	private int two;

	public MyClass(int one, int two) {
		this.one = one;
		this.two = two;
	}

	public int getOne() {
		return one;
	}

	public int getTwo() {
		return two;
	}
}

