package week4;

import java.util.Arrays;
import java.util.List;

public class Study {

	public static void main(String[] args) {
		String st = "29/04/1991";
		int day = Integer.parseInt(st.substring(0,2));
		int month = Integer.parseInt(st.substring(3,5));
		int yr = Integer.parseInt(st.substring(6,10));
		System.out.println("" + day + month + yr);
		
		System.out.println(day);
	}
	
}
