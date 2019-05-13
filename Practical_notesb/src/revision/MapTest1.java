package revision;

import java.util.*;
public class MapTest1 {
	public static void main(String[] args){
		// Hash map mapping employee number to accounts
		Map <String, String> accountsMap = new HashMap<String, String> ();
		accountsMap.put("E123","Charles"); accountsMap.put("E174","Matt");
		accountsMap.put("E542","Brendan");
		accountsMap.put("E174","Tobin");
		
		System.out.println(accountsMap);
		System.out.println(accountsMap.keySet());
		
		for (String en : accountsMap.keySet())
			System.out.println(accountsMap.get(en));
	}
}