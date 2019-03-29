package week2;

public class Account {
	
	private String name; 
	private String ID;
	private double balance;
	private int withdrawals = 0;
	
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
			withdrawals += 1;
			return true;
		}
		return false;
	}
	
	//for simplicity this method can just take no arguments.
	public String getName(Account acct) {
		return acct.name;
	}
	
	public boolean deposit(double amt) {
		balance += amt; 
		return true;
	}

	public boolean addInterest(double ir) {
		if (this.balance < 0) {
			return false;
		} else {
			this.balance *= 1 + ir;
			return true;
		}
	}
	
}


