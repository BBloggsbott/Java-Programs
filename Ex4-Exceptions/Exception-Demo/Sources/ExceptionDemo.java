import java.util.Scanner;
class ExceptionDemo{
	public static void main(String[] args){
		int op1,op2;
		char opt;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter two operands followed by on operator: ");
		op1=s.nextInt();
		op2=s.nextInt();
		opt=s.next().charAt(0);
		try{
			if((op1<10000)||(op1>50000)){
				throw new OperationFailedException(op1+Character.toString(opt)+op2,new BadOperandException(op1));
			}
			else if((op2<500)||(op2>5000)){
				throw new OperationFailedException(op1+Character.toString(opt)+op2,new BadOperandException(op2));
			}
			else if(opt=='+'){
				System.out.print(op1+Character.toString(opt)+op2+" = "+(op1+op2));
			}
			else if(opt=='-'){
				System.out.print(op1+Character.toString(opt)+op2+" = "+(op1-op2));
			}
			else if(opt=='*'){
				System.out.print(op1+Character.toString(opt)+op2+" = "+(op1*op2));
			}
			else if(opt=='/'){
				System.out.print(op1+Character.toString(opt)+op2+" = "+(op1/op2));
			}
			else{
				throw new OperationFailedException(op1+Character.toString(opt)+op2,new BadOperatorException(opt));
			}
		}
		catch(OperationFailedException ofe){
			System.out.println(ofe);
		}
	}
}