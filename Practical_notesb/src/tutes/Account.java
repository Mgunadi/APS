package tutes;

public class Account {
	
	private String name; private String ID;
	public double balance;
	
	public Account(String name, String ID, double balance) {
		this.name = name;
		this.ID = ID;
		this.balance = balance;
	}
	
	public void getBalance() {
		return balance;
	}
	
	public void withdraw(double amt) {
		balance -= amt;
	}
	
	public void deposit(double amt) {
		balance += amt; }
	}

}
