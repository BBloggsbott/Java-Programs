package pkaccount;	//Class Belongs to package pkaccount

public abstract class Account{
	protected int accnumber;
	protected double balance;
	public Account(int a,double b){
		accnumber = a;
		balance = b;
	}
	Account(){
		accnumber = 0;
		balance = 0;
	}
	public int returnAccno(){
		return accnumber;
	}
}
