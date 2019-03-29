package week3;

public class SAccount extends Account{

	private double minAmount; // subclass instance variable

	// constructor 1
	public SAccount(String accountID, String accountName, double amount, double minAmount){
		// call the super class constructor
		super(accountID, accountName, amount);
		this.minAmount = minAmount;
	}

	// constructor 2
	public SAccount(String accountID, String accountName, double amount){
		// call constructor 1 in the same class
		this(accountID, accountName, amount, 0.0);
	}

	// accessor for the subclass instance variable
	public double getMinAmount() {
		return minAmount;
	}

	// new method
	public void addInterest(double rate) { 
		deposit(getBalance() * rate/100);  
	}
	

	// overidden method		  		
	public boolean withdraw(double amount) {
		if (getBalance() >= amount + minAmount){
		    super.withdraw(amount);
		    return true;
		}
		else return false;
	}
	

	// overidden method
	public boolean transfer(Account account, double amount) {
		if (getBalance() >= amount + minAmount) {
		    super.withdraw(amount);
		    account.deposit(amount);
		    return true;
		}
		else return false;
	} 
}
