package ECommerce.dto;

import lombok.Data;

@Data
public class ProductDTO {
	
	private Long id;
	private String name;
	private int categoryId;
	private double price;
	private String imageName;
	
	
	public ProductDTO() {
		
	}


	public ProductDTO(Long id, String name, int categoryId, double price,String imageName) {
		
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.price = price;
		this.imageName = imageName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	

}