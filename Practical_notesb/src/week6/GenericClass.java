package week6;
import week3.Customer;

public class GenericClass {
	public static void main(String[] args) {
		
		//Stack of Customers
		Stack<Customer> custStack = new Stack<Customer>(10);
		custStack.push(new Customer("Bill", "Jones", 30));
		custStack.push(new Customer("Mary", "Bow", 25));
		System.out.println("This is: " + custStack.pop().getFirstname());
		
		//Stack of Strings
		Stack<String> strStack = new Stack<String>(10);
		strStack.push("Message 1");
		strStack.push("Message 2");
		System.out.println("This is: " + strStack.pop());
		
		//Stack of Accounts
		Stack<Account> accStack = new Stack<Account>(10);		
		accStack.push(new Account("s123", "Mary Brown", 1000));
		System.out.println("This is: " + accStack.pop().getName());
		
		//Compilation Error!!
		//accStack.push(new Customer("Victor", "Hugo", 45));
	}
}

class Stack<T> {
	private T[] elems;
	private int size;
	private int lastElem = -1;
	
	public Stack(int size) {
		elems = (T[]) new Object[size];
		this.size = size;
	}
	
	public boolean push(T o) {
		if (lastElem == size -1)
			return false;
		elems[++lastElem] = o;
		return true;
	}
	
	public T pop() {
		T o = elems[lastElem--];
		elems[lastElem + 1] = null;
		return o;
	}
	
}