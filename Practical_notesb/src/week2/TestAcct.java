package week2;

public class TestAcct {

	public static void main(String[] args) {
		Account a1 = new Account("Tan A K", "S123", 24.5);
		Account a2 = new Account("Smith T", "S124" ,1200.0);
		
		a1.deposit(100);
		a1.withdraw(2000);
		a2.deposit(120);
		a1.withdraw(80);
		
		System.out.println("Balance for " + a1.getName(a1) + " is " +
		a1.getBalance());
		
		System.out.println("Balance for " + a2.getName(a2) + " is " +
		a2.getBalance());
		
		a2.addInterest(0.05);
		System.out.println("Adding interest of 6% to Smith T ... " + a2.getBalance());

	}

}
