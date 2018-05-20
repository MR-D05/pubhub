package pubhub.pubhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pubhub.pubhub.model.Author;
import pubhub.pubhub.model.Order;
import pubhub.pubhub.model.User;
import pubhub.pubhub.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public void save(Author author) {
		authorRepository.save(author);
	}
	
	public Author findAuthorByUser(User user) {
		return authorRepository.findAuthorByUser(user);
	}
}
