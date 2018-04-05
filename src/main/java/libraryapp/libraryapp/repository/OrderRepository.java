package libraryapp.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import libraryapp.libraryapp.model.Order;
import libraryapp.libraryapp.model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	public Order findOrderByUserAndStatus(User user, String status);
	
}
