package ECommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ECommerce.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
