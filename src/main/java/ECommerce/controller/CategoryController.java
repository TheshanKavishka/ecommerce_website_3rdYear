package ECommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ECommerce.model.Category;
import ECommerce.repo.CategoryRepo;

@Controller
public class CategoryController {

	@Autowired
	CategoryRepo categoryRepository;
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public void removeCategoryById(int id) {
		categoryRepository.deleteById(id);
	}
	
	public Optional<Category> getCateByID(int id) {
		return categoryRepository.findById(id);
		
	}
}
