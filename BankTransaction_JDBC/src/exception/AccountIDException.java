package exception;

public class AccountIDException extends RuntimeException{
	public String getMessage() {
		return "Enter valid account ID";
	}
}
