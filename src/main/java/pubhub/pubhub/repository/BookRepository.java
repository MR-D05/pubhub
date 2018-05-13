package pubhub.pubhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pubhub.pubhub.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
	
	public Book getOne(String isbn13);

}
