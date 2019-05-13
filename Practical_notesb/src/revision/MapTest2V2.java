package revision;

import java.util.*;
public class MapTest2V2{
	public static void main(String[] args) {
		// HashMap mapping employee number to accounts
		Map <String, String> accountsMap = new HashMap<String,String>();
		accountsMap.put("E123","Homy");
		accountsMap.put("E156","Alex");
		accountsMap.put("E542","Rachel");
		accountsMap.put("E174","Tobin");
		
		Map <String, String> quotaMap = new HashMap <String, String>();
		// Hash map mapping accounts to quota
		quotaMap.put("Homy","5MB");
		quotaMap.put("Alex", "50MB");
		quotaMap.put("Rachel", "4MB");
		quotaMap.put("Bruce", "8MB");
		
		// get the collection of values (names) stored in the user map so that we can use them as map keys to look up quotavalues
		// in the quota map later 
		Collection users = accountsMap.values();
		// iterate through the collection of values (names) from the user map 
		for (Object user: users) {
		// get the value (quota) from the quota map which corresponds tothe current key (name) from the user map
			Object quota = quotaMap.get(user);
			// print the key (name)
			System.out.print("Name: " + user);
			// check to see if the key (name) had a corresponding value in the quota map
			if (quota == null) System.out.println(": No Quota Yet.");
			else
			// print the value (quota) from the quota map
			System.out.println(" Quota: " + (String)quota);
		}
	}
}
