package week2;
import java.util.*;


public class TestCasual {

	public static void main(String[] args) {
		Casual[] list = new Casual[3]; 
	
		list[0] = new Casual("1", "Bill", 20);
		list[1] = new Casual("2", "Sarah", 30);
		list[2] = new Casual("3", "John", 40);
	
		System.out.println(list[1].getName());
		
		list[0].addHour(20);
		list[1].addHour(10);
		list[2].addHour(5);
	
		double sum = 0;
		
		for ( int i = 0; i < 3; i ++){
			System. out .println("total pay of " + list[i].getName() + " is " + list[i].calcSalary());
			sum += list[i].calcSalary();
			}
		System.out.println("The total pay of all is " + sum );
		
		sum = 0;
		list [0].changeRate(22);
		list [1].changeRate(28);
		list [2].changeRate(50);
		
		list [0].addHour(20);
		list [1].addHour(10);
		list [2].addHour(5);
		
		for ( int i = 0; i < 3; i ++){
			System. out .println("total pay of " + list [i].getName() + " is " + list[i].calcSalary());
			sum += list[i].calcSalary();
		}
		
		System.out.println( "The total pay of all is now " + sum );
		
		
	}
}