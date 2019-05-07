package week8;

import java.util.*;

public class StringTokenizer1 {
	public static void main(String arg[]) {

		StringTokenizer stoken = new StringTokenizer("one two three");
		
		while (stoken.hasMoreTokens()) {
			System.out.println(stoken.nextToken());
		} 
		
		stoken = new StringTokenizer("Bill,Mary,Linda",",");

		while (stoken.hasMoreTokens()) {
			System.out.println(stoken.nextToken());
		}
		
		stoken = new StringTokenizer("1:Bill,2:Mary,3:Linda", ",");

		while (stoken.hasMoreTokens()) {
			StringTokenizer subToken = new StringTokenizer(stoken.nextToken());
			
			while (subToken.hasMoreTokens())
				System.out.println(subToken.nextToken(":"));
		}
	}
}