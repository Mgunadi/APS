package week6;
import week3.Customer;
import java.util.*;

public class HashMapGeneric {
	public static void main(String[] args) {

		HashMap<String, Account> hashMap1 = new HashMap<String, Account>();

		hashMap1.put("mum", new Account("s123", "Mercy Brown", 1000));
		hashMap1.put("dad", new Account("g234", "David Brown", 2000));
		
		// hashMap1.put(1234, new Account("S126","Unknown", 0.0)); WRONG
		
		System.out.println("Entries in Hashmap 1");
		displayMap(hashMap1);
		
		HashMap<Integer, Customer> hashMap2 = new HashMap<Integer, Customer>();

		hashMap2.put(1, new Customer());
		hashMap2.put(2, new Customer());
		
		// hashMap2.put(1234, new Account("S126","Unknown", 0.0)); WRONG
		
		System.out.println("\nEntries in Hashmap 2");
		displayMap(hashMap2);
	}

	public static <K, V> void displayMap(Map<K, V> m) {


		Set<K> keySet = m.keySet();
		Iterator<K> iterator = keySet.iterator();


		while (iterator.hasNext()) {
			K key = (K) iterator.next();
			System.out.println(key + " : " + m.get(key));
		}
	}
}


