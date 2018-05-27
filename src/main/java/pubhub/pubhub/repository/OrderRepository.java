package pubhub.pubhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pubhub.pubhub.model.Order;
import pubhub.pubhub.model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {

	public Order findOrderByUserAndStatus(User user, String status);

	public List<Order> findOrdersByUserAndStatus(User user, String status);

}
