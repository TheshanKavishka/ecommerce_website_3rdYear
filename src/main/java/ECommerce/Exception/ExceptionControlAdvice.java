package ECommerce.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControlAdvice {

	@ExceptionHandler(value = CustomException.class)
	public final ResponseEntity<String> handledCustomException(CustomException exception){

		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = AuthenticationFailException.class)
	public final ResponseEntity<String> handledAuthenticationFailException(AuthenticationFailException exception){
		
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
		
	}
	
	@ExceptionHandler(value = ProductNotExistsException.class)
	public final ResponseEntity<String> handledAuthenticationFailException( ProductNotExistsException exception){
		
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
		
	}
}
