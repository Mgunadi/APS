package week6;

import java.util.HashMap;
import java.util.Scanner;
import week3.Account;

public class HashMapDemo
{
	public static void main(String[] args)
	{
		// First create a hashmap with an initial size of 10 and
		// the default load factor
		HashMap accounts =	new HashMap(10);

		// Add several account objects to the map using
		// their short name as the key
		accounts.put("mum", new Account("s123", "Mercy Brown" , 1000));
		accounts.put("dad", new Account("g234", "David Brown" , 2000));		
		accounts.put("sister", new Account("x001", "Mary Brown" , 5000));		

		// Ask the user to type a name.  If found in the map,
		// print it out.
		Scanner keyboard = new Scanner(System.in);
		String name = "";
		
		do
		{
			System.out.print("\nEnter a name to look up in the map. ");
			System.out.println("Press enter to quit.");
			name = keyboard.nextLine();
			if (accounts.containsKey(name))
			{
				Account acc = (Account) accounts.get(name);
				System.out.println("Name found: " + acc.getName() 
						           + "\nBalance: " + acc.getBalance());
			}
			else if (!name.equals(""))
			{
                System.out.println("Name not found.");
            }
        } while (!name.equals(""));
    }
}

