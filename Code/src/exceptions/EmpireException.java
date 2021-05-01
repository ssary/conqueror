package exceptions;

abstract public class EmpireException extends Exception{
	public static final long serialVersionUID = 0L;
	public EmpireException() { 
		super() ;
	}
	public EmpireException(String s){
		super(s);
	}
	
	
}
