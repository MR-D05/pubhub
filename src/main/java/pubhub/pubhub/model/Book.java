package pubhub.pubhub.model;

import java.util.List;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "isbn13")
	private String isbn13; // International Standard Book Number, unique

	@Column
	private String title;

	@Column
	private String author;

	@Column
	private byte[] content;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "isbn13", cascade = CascadeType.ALL)
	public List<BookTag> booktags;

	// Constructor used when a date is specified
	public Book(String isbn, String title, String author, byte[] content) {
		this.isbn13 = isbn;
		this.title = title;
		this.author = author;
		this.content = content;
	}

	// Default constructor
	public Book() {
		this.isbn13 = null;
		this.title = null;
		this.author = null;
		this.content = null;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public List<BookTag> getBookTags() {
		return booktags;
	}

	public void setBookTags(List<BookTag> bookTags, List<BookTag> booktags) {
		this.booktags = booktags;
	}
}
