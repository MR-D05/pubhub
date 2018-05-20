package pubhub.pubhub.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "orderid")
	private Order order;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookid")
	private Book book;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "ordered")
	private LocalDateTime ordered;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void releaseFromOrder() {
		this.order = null;
	}

	public void addItemToOrder() {
		this.order = null;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getOrdered() {
		return ordered;
	}

	public void setOrdered(LocalDateTime ordered) {
		this.ordered = ordered;
	}

	public Item(Long id, Order order, Book book, Integer quantity, LocalDateTime ordered) {
		super();
		this.id = id;
		this.order = order;
		this.book = book;
		this.quantity = quantity;
		this.ordered = ordered;
	}

	public Item() {
		super();
		this.id = null;
		this.order = null;
		this.book = null;
		this.quantity = null;
		this.ordered = null;
	}
}