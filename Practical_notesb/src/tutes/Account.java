package tutes;

public class Account {
	
	private String name; private String ID;
	public double balance;
	
	public Account(String name, String ID, double balance) {
		this.name = name;
		this.ID = ID;
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean withdraw(double amt) {
		if (balance > amt) {
			balance -= amt;
			return true;
		}
		return false;
	}
	
	public String getName(Account acct) {
		return acct.name;
	}
	
	public boolean deposit(double amt) {
		balance += amt; 
		return true;
	}

}


