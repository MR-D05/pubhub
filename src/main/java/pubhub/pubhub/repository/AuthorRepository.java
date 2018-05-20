package pubhub.pubhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pubhub.pubhub.model.Author;
import pubhub.pubhub.model.User;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	public Author findAuthorByUser(User user);

}