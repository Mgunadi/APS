package revision;



public class OverloadConstructor {
	   private String name;
	   private double balance;
	   private String accID;
	   
	   public OverloadConstructor(String accID, String accName, double amount) {
		   this.accID   = accID;
		   name    = accName;
		   balance = amount;
	   }
	   
	   public OverloadConstructor(String accID, String accountName) {
		   this(accID, accountName, 0); 					//will draw from constructor 1
	   }
	   
	   public OverloadConstructor(String accID) {
		   this(accID, "Name Unknown");						//will draw from constructors 1 and 2
	   }
	   
	   public static void main(String[] args) {
		   OverloadConstructor Matthew = new OverloadConstructor("Matt");
		   System.out.println(Matthew.balance);
	   }
}


