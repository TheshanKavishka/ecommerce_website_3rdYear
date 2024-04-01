package ECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ECommerce.global.GlobalData;
import ECommerce.service.CategoryService;
import ECommerce.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/home")
	public String getHome() {
		return "Home";
	}
	
	@GetMapping("/contacts")
	public String getContact() {
		return "Contact";
	}
	
	@GetMapping("/feedback")
	public String getFeedback() {
		return "Feedback";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:Login";
	}
	
	@GetMapping("/Login")
	public String login() {
		return "Login";
	}
	
	@GetMapping("/chooseproduct")
	public String shop(Model model) {
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("products",productService.getAllProduct());
		model.addAttribute("cartCount",GlobalData.cart .size());
		return "ChooseProduct";
	}
	
	
	@GetMapping("/chooseproduct/category/{id}")
	public String shopByCategory(Model model,@PathVariable int id) {
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("products",productService.getAllProductsByCategoryId(id));
		model.addAttribute("cartCount",GlobalData.cart .size());
		return "ChooseProduct";
	}
	
	@GetMapping("/chooseproduct/viewproduct/{id}")
	public String viewProduct(Model model,@PathVariable int id) {
		model.addAttribute("product",productService.getProductById(id).get());
		model.addAttribute("cartCount",GlobalData.cart .size());
		return "viewProduct";
	}
	
	
	
}
