package ECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ECommerce.dto.ResponseDto;
import ECommerce.dto.SignInDto;
import ECommerce.dto.SignInResponseDto;
import ECommerce.dto.SignUpDto;
import ECommerce.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/register")
	public String register() {
		return "Register";
	}
	
	//sign up
	@PostMapping("/user/signup")
	public ResponseDto signUp(@RequestBody SignUpDto signupdto) {
		return userservice.signUp(signupdto);
	}
	
	
	//sign in
	@PostMapping("/user/signin")
	public SignInResponseDto signIn(@RequestBody SignInDto signindto) {
		return userservice.signIn(signindto);
	}
	
	
	@PostMapping("/user/saveUser")
	public String adduser(@ModelAttribute SignUpDto signupdto) {
		userservice.signUp(signupdto);
		return "redirect:/Login";
	}
	
	@PostMapping("/user/userlogin")
	public String userLogin(@ModelAttribute SignInDto dto) {
		userservice.signIn(dto);
		return "redirect:/admin";
	}
	
}
