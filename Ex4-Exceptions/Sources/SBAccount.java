package pkaccount.sb;
import pkaccount.*;
import pkbanking.pkinterface.*;
import pkbanking.pkexception.*;

public class SBAccount extends Account implements Transaction,InterestRate{
  public SBAccount(int acc_number,double init_balance){
		super(acc_number,init_balance);
	}

	public void withdraw(double amt) throws Exception{
		if(amt<=0){
			throw new IllegalArgumentException();
		}
		else if((balance-amt)<min_balance){
			throw new InsufficientFundsException();
		}
		else{
			balance-=amt;
			System.out.println("Withdraw Successful");
		}
	}

	public void deposit(double amt) throws Exception{
		if(amt>0){
			balance += amt;
			System.out.println("Deposit Successful");
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	public void calc_interest(){
		double intrst;
		intrst = balance * sbrate;
		balance += intrst;
		System.out.println("Interest Credited to balance");
	}
}
