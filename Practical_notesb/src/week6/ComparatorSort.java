package week6;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ComparatorSort {

	public static void main(String[] args) {
		List<AccountT> accounts = new ArrayList<>();
		accounts.add(new AccountT("John", 99.34));
		accounts.add(new AccountT("Mary", 22.33));
		accounts.add(new AccountT("Harry", 3434.3));
	
		//Sort by name of the Account:
		Collections.sort(accounts, new NameComparator());
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println(accounts.get(i));
		}
		
		System.out.println();
		
		//Sort by balance of the Account:
		Collections.sort(accounts, new BalanceComparator());
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println(accounts.get(i));
		}
;	}
}

class AccountT{
	private String name;
	private double balance;
	
	public AccountT(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String toString() {
		return "Account[name = " + name + ", balance = " + balance + "]";
	}
}

class NameComparator implements Comparator<AccountT> {
	@Override
	public int compare(AccountT a1, AccountT a2) {
		return a1.getName().compareTo(a2.getName());
	}	
}

class BalanceComparator implements Comparator<AccountT>{
	@Override
	public int compare(AccountT a1, AccountT a2) {
		if(a1.getBalance() < a2.getBalance()) {
			return -1;
		}else if(a1.getBalance() == a2.getBalance()) {
			return 0;
		}else {
			return 1;
		}
	}
}