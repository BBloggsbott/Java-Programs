class SBAccount extends Account{	//SBAccount inherits Account
	SBAccount(int acno, double init_balance){	//Parametrized constuctor to initialize datamembers
		accNo=acno;
		balance=init_balance;
	}
	void deposit(double amt){	//Function to deposit amount to account
		if(amt>0){
			balance=balance+amt;
			System.out.println("Amount Deposited!! Balance Updated!!");
		}
		else
			System.out.println("Incorrect amount entered!!! Balance not updated");
	}
	
	void withdraw(double amt){	//Function to withdraw money from account
		if(balance-amt>=1000){
			balance=balance-amt;
			System.out.println("Anount Withdrawn!! Balance Updated!!");
		}
		else
			System.out.println("Amount cannot be withdrawn. Insufficient balance after withdrawal. Balance not updated!!");
		
	}
	void calc_interest(){	//Function to calculate interest
		double intrst;
		intrst=balance*4;
		intrst=intrst/100;
		balance=balance+intrst;
	}
	void calc_interest_1year(int noy){
		double intrst;
		intrst=balance*4*noy;
		intrst=intrst/100;
		balance=balance+intrst;
	}
}
	
	
