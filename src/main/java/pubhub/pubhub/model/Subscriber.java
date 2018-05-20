package pubhub.pubhub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subscribers")
public class Subscriber {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User user;

	@ManyToOne
	@JoinColumn(name = "authorid")
	private Author author;

	public void releaseFromAuthor() {
		this.author = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subscriber(Long id, User user) {
		super();
		this.id = id;
		this.user = user;
	}

	public Subscriber() {
		super();
	}
}
