package pubhub.pubhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pubhub.pubhub.model.Book;
import pubhub.pubhub.repository.BookRepository;

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
