package ECommerce.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ECommerce.Exception.AuthenticationFailException;
import ECommerce.Exception.CustomException;
import ECommerce.dto.ResponseDto;
import ECommerce.dto.SignInDto;
import ECommerce.dto.SignInResponseDto;
import ECommerce.dto.SignUpDto;
import ECommerce.model.AuthenticationToken;
import ECommerce.model.User;
import ECommerce.repo.UserRepo;
import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired 
	UserRepo userrepo;
	
	@Autowired
	AuthenticationService authenticatioservice;

	@Transactional
	//If we generated the user and then if the token is not saved then we will revert the 
	//newly created user - @Transactional
	public ResponseDto signUp(SignUpDto signupdto) {
		
		//check if user is already present
		if(Objects.nonNull(userrepo.findByEmail(signupdto.getEmail()))) {
			throw new CustomException("user already present");
		}

		//hash the password
		String encryptedpassword = signupdto.getPassword();
		
		try {
			encryptedpassword = hashPassword(signupdto.getPassword());
			
		}catch(NoSuchAlgorithmException e){
			
			e.printStackTrace();
			throw new CustomException(e.getMessage());
		}
		
		User user =new User(signupdto.getFirstName(),signupdto.getLastname(),signupdto.getEmail(),encryptedpassword);
		
		userrepo.save(user);
		//save the user 
		
		
		//create the token
		final AuthenticationToken authenticationtoken = new AuthenticationToken(user);
		authenticatioservice.saveConfimationToken(authenticationtoken);
		
		ResponseDto responsedto = new ResponseDto("success","user has been created succesfuly");
		return responsedto;
		 
	}

	private String hashPassword(String password) throws NoSuchAlgorithmException {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 md.update(password.getBytes());
		 byte[] digest = md.digest();
		 String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return hash;
	}

	public SignInResponseDto signIn(SignInDto signindto) {
		User user = userrepo.findByEmail(signindto.getEmail());
		
		if(Objects.isNull(user)) {
			throw new AuthenticationFailException("Invalid User");
		}else {
			try {
				if(user.getPassword().equals(hashPassword(signindto.getPassword()))) {
					
					
				}else {
					throw new AuthenticationFailException("password Incorrect");
				}
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			 AuthenticationToken token = authenticatioservice.getToken(user);
			 
			 if(Objects.isNull(token)) {
				 
				 throw new CustomException("Token is not present");
			 }else {
				 return new SignInResponseDto("success",token.getToken());
			 }
			 
			
		}
		
		 
		
		 
	}
	   
}
