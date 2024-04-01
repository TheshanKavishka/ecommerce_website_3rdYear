package ECommerce.Exception;

public class CustomException extends IllegalArgumentException{

	private static final long serialVersionUID = 5261167887194069614L;

	public CustomException(String msg) {
		super(msg);
	}
}
