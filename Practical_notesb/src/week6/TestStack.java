package week6;
import week3.Customer;

public class TestStack{
	public static void main(String[] args) {

		Stack1 myStack = new Stack1(10);

		myStack.push("A String Input");

		myStack.push(new Customer("Bill", "Jones", 30));
		myStack.push(new Customer("Mary", "Bow", 25));

		myStack.push(new Account("s123", "Mary Brown", 1000));


		//Oops! Runtime Error
		Customer c = (Customer) myStack.pop();
		System.out.println("This is: " + c.getFirstname());
	}
}

class Stack1 {
	private Object[] elems;
	private int size;
	private int lastElem = -1;

	public Stack1(int size) {
		elems = new Object[size];
		this.size = size;
	}


      //add an element at the top
	public boolean push(Object o) {
		if (lastElem == size - 1)
			return false;
		elems[++lastElem] = o;
		return true;
	}


      //remove the top element
	public Object pop() {
		Object o = elems[lastElem--];
		elems[lastElem + 1] = null;
		return o;
	}
}

