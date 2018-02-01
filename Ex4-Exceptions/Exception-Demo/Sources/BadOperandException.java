class BadOperandException extends Exception{
	private int op;
	BadOperandException(int x){
		super();
		op=x;
	}
	public String toString(){
		return ("Bad Operand: "+op);
	}
}
