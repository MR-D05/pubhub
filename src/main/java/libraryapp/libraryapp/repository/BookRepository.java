package libraryapp.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import libraryapp.libraryapp.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
	
	public Book getOne(String isbn13);

}
