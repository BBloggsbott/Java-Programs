public class BankDemo{	//Class to demonstrate the inherited capabilities
  public static void main(String[] args){
    Customer c=new Customer(1,"Adam","La La Land");
    c.createAccount(1);
    c.transaction(3);
    c.createAccount(2);
    c.transaction(1);
    c.transaction(2);
    c.createAccount(5);
  }
}
