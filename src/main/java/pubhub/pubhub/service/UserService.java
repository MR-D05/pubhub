package pubhub.pubhub.service;

import java.util.List;

import pubhub.pubhub.model.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);

	User findByUserameAndPassword(String name, String password);

	List<User> findAll();

	User getOne(Long userid);

}
