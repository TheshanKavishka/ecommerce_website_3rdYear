package ECommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ECommerce.model.AuthenticationToken;
import ECommerce.model.User;

@Repository
public interface TokenRepo extends JpaRepository<AuthenticationToken,Integer>{

	AuthenticationToken findByUser(User user); 
	AuthenticationToken findByToken(String token);
}
