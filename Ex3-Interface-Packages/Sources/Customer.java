package pkcustomer;
//Importing required packages
import pkaccount.sb.*;
import pkaccount.fd.*;
import pkaccount.*;
import java.util.*;
public class Customer{
	int cust_id,sbNo,fdNo;
	String name,address;
	SBAccount[] sba = new SBAccount[5];
	FDAccount[] fda = new FDAccount[5];
	Scanner s = new Scanner(System.in);
	public Customer(int cusID,String nm,String addr){
		cust_id = cusID;
		name = nm;
		address = addr;
		sbNo=fdNo=0;
	}
	
	public void createAccount(int type){
		if(type == 1){
			System.out.println("Enter Account number and Initial Balance: ");
			sba[sbNo] = new SBAccount(s.nextInt(),s.nextDouble());
			sbNo++;
		}
		else if(type == 2){
			System.out.println("Enter Account number, Period and Initial Balance: ");
			fda[fdNo] = new FDAccount(s.nextInt(),s.nextInt(),s.nextDouble());
			fdNo++;
		}
	}
	
	public void transaction(int type){
		int flag=0,i,j,acno;
		System.out.println("Enter Account Number: ");
		acno=s.nextInt();
		for(i=0;i<sbNo;i++){
			if(sba[i].returnAccno()==acno){
				flag=1;
				break;
			}
		}
		for(j=0;j<fdNo;j++){
			if(fda[j].returnAccno()==acno){
				flag=2;
				break;
			}
		}
		if(flag==1){
			if(type==1){
				System.out.println("Enter Amount: ");
				sba[i].deposit(s.nextDouble());
				return;
			}
			else if(type==2){
				System.out.println("Enter Amount: ");
				sba[i].withdraw(s.nextDouble());
				return;
			}
			else if(type==3){
				sba[i].calc_interest();
				return;
			}
		}
		else if(flag==2){
			if(type==4){
				fda[i].close();
				return;
			}
		}
		else{
			System.out.println("Account not Found!!");
			return;
		}
		System.out.println("Invalid Choice");
	}
	public int returnCustID(){
		return cust_id;
	}
}
	
