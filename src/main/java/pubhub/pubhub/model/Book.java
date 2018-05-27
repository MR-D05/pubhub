package pubhub.pubhub.model;

import java.util.List;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String isbn13;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User user;

	@Column
	private String title;

	@Column
	private String authorname;

	@Column
	private byte[] content;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "isbn13", cascade = CascadeType.ALL)
	public List<BookTag> booktags;

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public List<BookTag> getBooktags() {
		return booktags;
	}

	public void setBooktags(List<BookTag> booktags) {
		this.booktags = booktags;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Book(String isbn13, User user, String title, String authorname, byte[] content, List<BookTag> booktags) {
		super();
		this.isbn13 = isbn13;
		this.user = user;
		this.title = title;
		this.authorname = authorname;
		this.content = content;
		this.booktags = booktags;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

}
