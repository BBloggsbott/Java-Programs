 class FDAccount extends Account{	//FDAccount inherits Account
	 private int period;
	 FDAccount(int acno, double init_balance, int prd){	//Parametrized constructor to intialize data members
		accNo=acno;	
		balance=init_balance;
		period=prd;
	}

	double calc_interest(){	//Function to calculate the interest for the account
		double interest;
		interest = balance * 8.25 * period;
    interest=interest/100;
    System.out.println(interest);
		return interest;
	}

	void close(){	//Function to close the account
		double interest;
		interest = calc_interest();
		balance=balance+interest;
	}
}
