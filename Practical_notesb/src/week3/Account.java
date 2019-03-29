package week3;

public class Account {
	private Customer cus;
	private String name;
	private double balance;
	private String accID;
	
	//This constructor checks to see if the value of amount argument is < 0, if so, then set it to 0
	public Account(String accID, String accountName, double amount) {
		this.accID   = accID;
		name = accountName;
				
		if (amount < 0)   balance = 0;
		else balance = Math.round(amount);
	   }

	//This constructor uses an object value, Customer, as one of the arguments
    public Account(String accID, String firstName, String surName, int age, double amount) {
        this.accID   = accID;
        this.cus = new Customer(firstName, surName, age);
				
        if (amount < 0)   balance = 0;
        else balance = Math.round(amount);

    }
    
    //Customer example
    public Account(String accID, Customer cus, double amount) {
         this.accID   = accID;
         this.cus = cus;				
         if (amount < 0)   balance = 0;
         else balance = Math.round(amount);
     }
    
    //Customer example
	 public Customer getCus() {
		return cus;
	 }	
	
	 public double getBalance() {
		 return balance;
	 }
	   
	 public String getID() {
	     return accID;
	 }
	 
	 public String getName() {
	     return name;
	 }
	
	 public void deposit(double amount) {
	      balance = balance + amount;
	   }
			
	 public boolean withdraw(double amount) {
	     boolean result = false;
	     if ( balance >= amount ) {
	         result = true;
		 balance -= amount;
	      }
	      return result;

	   }
			
	 public boolean transfer(Account account, double amount) {
	      if (balance >= amount) {
	         balance = balance - amount; // or  withdraw(amount);
		 account.deposit(amount);
		 return true;
	      }
	      else return false;
	 } 
	 
	 
	 
}
