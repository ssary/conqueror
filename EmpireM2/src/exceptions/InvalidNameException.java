package exceptions;

public class InvalidNameException extends Exception{
	public InvalidNameException() {
		super();
	}

	public InvalidNameException(String s) {
		super(s);
	}
}
