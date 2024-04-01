package ECommerce.Exception;

public class AuthenticationFailException extends IllegalArgumentException{


	
	private static final long serialVersionUID = 7950303466203991779L;

	public AuthenticationFailException(String msg) {
		super(msg);
	}

}
