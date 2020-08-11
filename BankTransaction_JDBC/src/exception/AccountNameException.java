package exception;

public class AccountNameException extends RuntimeException{
	public String getMessage() {
		return "Enter valid account Name";
	}
}
