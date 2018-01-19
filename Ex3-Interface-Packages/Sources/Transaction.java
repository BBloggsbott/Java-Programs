 package pkbanking.pkinterface;
 //Interface for transactions
 public interface Transaction{
	 public final double min_balance = 500;
	 public void withdraw(double amt);
	 public void deposit(double amt);
 }
 
 
