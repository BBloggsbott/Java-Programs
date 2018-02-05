class OperationFailedException extends Exception{
	private String des;
	OperationFailedException(String s){
		super();
		des=s;
	}
	OperationFailedException(String s,Throwable Th){
		super();
		des=s;
		this.initCause(Th);
	}
	public String toString(){
		return ("Failed Operation: "+des);
	}
}
