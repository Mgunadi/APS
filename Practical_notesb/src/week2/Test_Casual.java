package week2;
import java.util.*;
import java.text.*;

public class Test_Casual {

	public static void main(String[] args) {
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		Casual Matt = new Casual("S3740473", "Matt", 28.3, 40, 1500);
		
		System.out.println("Matt's current salary is: " + Matt.calcSalary());
		System.out.println("Matt's current rate is: " + Matt.getRate());
		
		System.out.println("Matt gets a pay rise.");
		
		Matt.changeRate(6);
		System.out.println("Matt's new rate is: " + numberFormat.format(Matt.getRate()) + " and works some more hours");
		
		Matt.addHour(10);
		
		//set the number of dps to 2.
		System.out.println("Now his new salary is: " + numberFormat.format(Matt.calcSalary()));

	}

}
