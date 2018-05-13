package pubhub.pubhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pubhub.pubhub.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByNameAndPassword(String name, String password);

} 