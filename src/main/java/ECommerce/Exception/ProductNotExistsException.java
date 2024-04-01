package ECommerce.Exception;

public class ProductNotExistsException extends IllegalArgumentException {

	private static final long serialVersionUID = 7866723803139772506L;
	public ProductNotExistsException(String msg) {
		super(msg);
	}
}
