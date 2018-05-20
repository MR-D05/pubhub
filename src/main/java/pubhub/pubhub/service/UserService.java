package pubhub.pubhub.service;

import pubhub.pubhub.model.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);

	User findByUserameAndPassword(String name, String password);

}
