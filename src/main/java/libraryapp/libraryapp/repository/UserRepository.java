package libraryapp.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import libraryapp.libraryapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByNameAndPassword(String name, String password);

} 