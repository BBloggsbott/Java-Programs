package pkaccount.fd;
import pkaccount.*;
import pkbanking.pkinterface.*;
import pkbanking.pkexception.*;

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
