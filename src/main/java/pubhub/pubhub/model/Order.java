package pubhub.pubhub.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GenericGenerator(name="BIGINT", strategy="increment")
	@GeneratedValue(generator="BIGINT")
	@Column(name="id")
	private Long id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private User user;
	
	@OneToMany(mappedBy="order", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Item> items;

	@Column(name="status")
	private String status;

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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void clearItems() {
		for(Item item : items) {
			item.releaseFromOrder();
		}
		items.clear();
	}
	
	public void removeItem(String isbn13) {
		for(Item item : items) {
			if(item.getBook().getIsbn13().equals(isbn13)) {
				item.releaseFromOrder();
			}
		}
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Order(Long id, User user, List<Item> items, String status, LocalDateTime ordered,
			LocalDate cancelled, LocalDate delivered) {
		super();
		this.id = id;
		this.user = user;
		this.items = items;
		this.status = status;
	}

	public Order() {
		super();
	}

}