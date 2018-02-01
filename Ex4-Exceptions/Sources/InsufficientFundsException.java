package pkbanking.pkexception;
public class InsufficientFundsException extends Exception{
	private String description;
	public InsufficientFundsException(){
		description="Insufficient Funds";
	}
	public InsufficientFundsException(String ex){
		description=ex;
	}
	public String toString(){
		return description;
	}
}
