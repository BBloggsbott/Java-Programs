public class BadOperatorException extends Exception{
	private char opr;
	public BadOperatorException(char ch){
		super();
		opr=ch;
	}
	public String toString(){
		return("Bad operator: "+opr);
	}
}
