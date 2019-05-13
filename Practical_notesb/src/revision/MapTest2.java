package revision;

import java.util.*;
public class MapTest2{
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
		
		for (String e: accountsMap.keySet()) {
			String quota = quotaMap.get(accountsMap.get(e));
			if (quota == null){
				quota = "no quota yet";
			}
			System.out.println(e + " " + accountsMap.get(e) + ": " + quota);
			System.out.println();
		}
	}
}