import java.util.Scanner;
class Customer{
  private int cust_id;
  private int accType;
  private String name;
  private String address;
  private FDAccount fdacc;
  private SBAccount sbacc;
  Customer(int cID, String cName,String cAddr){	//Parametrized constructor to initialize the data members
    cust_id=cID;
    name=cName;
    address=cAddr;
  }
  void createAccount(int type){	//Function to create account
    Scanner reader = new Scanner(System.in);
    int accno,prd;
    double balance;
    if(type==1){        //FD Account
      System.out.println("Enter The Acc. No.:");
      accno=reader.nextInt();
      System.out.println("Enter balance:");
      balance=reader.nextDouble();
      System.out.println("Enter Period:");
      prd=reader.nextInt();
      fdacc=new FDAccount(accno,balance,prd);
      System.out.println("FD Account created!!");
      accType=1;
    }
    else if(type==2){
      System.out.println("Enter The Acc. No.:");
      accno=reader.nextInt();
      System.out.println("Enter balance:");
      balance=reader.nextDouble();
      sbacc=new SBAccount(accno,balance);
      System.out.println("SB Account created!!");
      accType=2;
    }
    else
      System.out.println("Invalid input!!");

  }
  void transaction(int type){	//Functon to perform transaction on an account
    Scanner reader = new Scanner(System.in);
    double amount;
    if(type==1){
      System.out.println("Enter Amount:");
      amount=reader.nextDouble();
      sbacc.deposit(amount);
    }
    else if(type==2){
      System.out.println("Enter Amount:");
      amount=reader.nextDouble();
      sbacc.withdraw(amount);
    }
    else if(type==3){
      fdacc.close();
      System.out.println("Account Closed!!");
    }
    else
      System.out.println("Invalid Choice");
  }

}
