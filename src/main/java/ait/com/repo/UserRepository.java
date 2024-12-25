package ait.com.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import ait.com.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// find A User By Email
	Optional<User> findByEmail(String email);

	// find A User By Roll
	List<User> findByroll(String roll);

}
