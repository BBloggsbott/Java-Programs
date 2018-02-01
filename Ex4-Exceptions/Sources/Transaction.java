package pkbanking.pkinterface;
import pkbanking.pkexception.*;

public interface Transaction{
	public double min_balance = 500;
	public void withdraw(double amt) throws Exception;
	public void deposit(double amt) throws Exception;
}
