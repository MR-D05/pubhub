package pubhub.pubhub.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "channels")
public class Channel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "userid")
	private User user;

	// @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval =
	// true)
	// private List<Message> messages;

	@ManyToMany(mappedBy = "channels")
	private Collection<User> users;

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

	// public List<Message> getMessages() {
	// return messages;
	// }
	//
	// public void setMessages(List<Message> messages) {
	// this.messages = messages;
	// }

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Channel(Long id, User user, Collection<User> users) {
		super();
		this.id = id;
		this.user = user;
		this.users = users;
	}

	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
