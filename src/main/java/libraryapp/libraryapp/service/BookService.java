package libraryapp.libraryapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import libraryapp.libraryapp.model.Book;
import libraryapp.libraryapp.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public void save(Book book) {
		bookRepository.save(book);
	}
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findOne(String isbn13) {
		return bookRepository.getOne(isbn13);
	}
}
