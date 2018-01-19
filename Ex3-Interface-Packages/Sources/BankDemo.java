import pkcustomer.*;
import java.util.Scanner;
class BankDemo{
	public static void main(String[] args) {
		Customer[] c = new Customer[5];
		int i,type,ch=1,ID,choice,cNo=0,flag=0;
		Scanner s = new Scanner(System.in);
		do{
			System.out.println("Menu\n1.Create Customer\n2.Manage Customer\n3.Exit\nEnter Choice: ");
			choice=s.nextInt();
			if(choice==1){
				System.out.println("Enter Customer ID, Name, Address in order:\n");
				c[cNo]=new Customer(s.nextInt(),s.next(),s.next());
				cNo++;
				System.out.println("Customer Created");
			}
			else if(choice==2){
				System.out.println("Enter Customer ID: ");
				ID=s.nextInt();
				for(i=0;i<cNo;i++){
					if(c[i].returnCustID()==ID){
						flag=1;
						break;
					}
				}
				do{
					if(flag!=0){
						System.out.println("\nCutomer Management Menu:\n1.Create Account\n2.Manage Accounts\n3.Exit\nEnter Choice: ");
						ch=s.nextInt();
						if(ch==1){
							System.out.println("Account Type:\n1.SB Account\n2.FD Account\nEnter Account type: \n");
							c[i].createAccount(s.nextInt());
						}
						else if(ch==2){
							System.out.println("Account MAnagement Menu\n1.SB Account Deposit\n2.SB Account Withdraw\n3.SB Account Calculate interest");
							System.out.println("4.FD Account Close\n5.Exit\nEnter Choice: ");
							c[i].transaction(s.nextInt());
						}
					}
				}while(ch!=3);
			}
		}while(choice!=3);
	}
}
