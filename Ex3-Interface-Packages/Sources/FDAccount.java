package pkaccount.fd;
//Importing Required pacages
import pkbanking.pkinterface.*;
import pkaccount.*;

public class FDAccount extends Account implements InterestRate{
	int period;
	public FDAccount(int acc_number,int prd,double init_balance){
		super(acc_number,init_balance);
		period = prd;
	}
	
	double calc_interest(){
		return balance * fdrate * period;
	}
	
	public void close(){
		balance += calc_interest();
	}
}
