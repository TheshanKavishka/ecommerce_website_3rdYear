package ECommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ECommerce.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
	User findByEmail(String email);
}
