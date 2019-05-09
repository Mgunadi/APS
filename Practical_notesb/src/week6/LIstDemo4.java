package week6;
import java.util.*;

class ListDemo4 {
	public static void main(String[] args) {
		
	Account accArray[] ={ 

               new Account("s123", "Mercy Brown" , 5000),
               new Account("g234", "David Brown" , 3000),		
               new Account("x001", "Mary Brown" , 2000)};
		
      List accounts = Arrays.asList(accArray);
      Collections.sort(accounts);
        
      for (Object acc : accounts){
        System.out.println("Name: " + ((Account)acc).getName());
        System.out.println("Balance: " + ((Account)acc).getBalance());
      }
   }
}

class Account implements Comparable{
	   private String name;
	   private double balance;
	   private String accID;
	   
	   public double getBalance() {  return balance;}
	   public String getID() { return accID; }
	   public String getName() { return name; }

	   public Account(String accID, String accountName, double amount) {
			this.accID   = accID;
			name = accountName;
					
			if (amount < 0)   balance = 0;
			else balance = Math.round(amount);
		   }
	   
	   public Account(String accID, String accountName) { }
	   
	   public Account(String accID) { }	

	   public void deposit(double amount) { }
		
	   
	   public int compareTo(Object o){  //override the interface method, compareTo, for the object, Account.
		   
		   if (getBalance() < ((Account) o ).getBalance()) return -1;

		   if (getBalance() > ((Account) o ).getBalance()) return 1;
		  
		   return 0;		   
	   }
}