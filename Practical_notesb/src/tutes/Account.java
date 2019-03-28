package tutes;

public class Account {
	Testersds
	

	private String name; private String ID;
	public double balance;
	
	public void Account(String name, String ID, double balance) {
		name = name;
		ID = ID;
		balance = balance;
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
