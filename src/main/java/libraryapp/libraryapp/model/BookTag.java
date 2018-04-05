package libraryapp.libraryapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tags")

public class BookTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@JoinColumn(name = "isbn13")
	@Column(name = "isbn13")
	private String isbn13; // International Standard Book Number, unique

	@Id
	private String tag; // Book tags

	// Default Constructor
	public BookTag() {
		this.isbn13 = null;
		this.tag = null;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
