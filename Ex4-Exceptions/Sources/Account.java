package pkaccount;

public class Account{
  protected int accno;
  protected double balance;
  public Account(){
    accno=0;
    balance=0.0;
  }
  public Account(int acno,double bal){
    accno=acno;
    balance=bal;
  }
  public int returnAccno(){
    return accno;
  }
}
