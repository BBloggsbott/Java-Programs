package pkaccount.sb;
//Importing Required Packages
import pkbanking.pkinterface.*;
import pkaccount.*;
public class SBAccount extends Account implements Transaction,InterestRate{ //Implements the interfacce Transaction, and InterestRate
	public SBAccount(int acc_number,double init_balance){
		super(acc_number,init_balance);
	}
	
	public void withdraw(double amt){
		if(amt<=0){
			System.out.println("Invalid Amount");
		}
		else if((balance-amt)<min_balance){
			System.out.println("Insufficient Balance");
		}
		else{
			balance-=amt;
			System.out.println("Withdraw Successful");
		}
	}
	
	public void deposit(double amt){
		if(amt>0){
			balance += amt;
			System.out.println("Deposit Successful");
		}
		else{
			System.out.println("Invalid Amount");
		}
	}
	
	public void calc_interest(){
		double intrst;
		intrst = balance * sbrate;
		balance += intrst;
		System.out.println("Interest Credited to balance");
	}
		
}
