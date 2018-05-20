package pubhub.pubhub.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pubhub.pubhub.model.Role;
import pubhub.pubhub.model.User;
import pubhub.pubhub.repository.UserRepository;
import pubhub.pubhub.repository.RoleRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		Role userRole = roleRepository.findByName("ROLE_USER");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(Arrays.asList(userRole));
		user.setEnabled(true);
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByUserameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
}
