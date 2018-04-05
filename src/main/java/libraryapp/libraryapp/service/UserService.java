package libraryapp.libraryapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import libraryapp.libraryapp.model.User;
import libraryapp.libraryapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
	}

	public User findByNameAndPassword(String name, String password) {
		return userRepository.findByNameAndPassword(name, password);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
}
