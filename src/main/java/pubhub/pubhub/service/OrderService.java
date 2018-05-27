package pubhub.pubhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pubhub.pubhub.model.Order;
import pubhub.pubhub.model.User;
import pubhub.pubhub.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order findOrderByUserId(Long id) {
		return orderRepository.getOne(id);
	}

	public List<Order> findOrdersByUserId(Long id) {
		return orderRepository.findAll();
	}

	public Order findOrderByUserAndStatus(User user, String status) {
		return orderRepository.findOrderByUserAndStatus(user, status);
	}

	public void save(Order order) {
		orderRepository.save(order);
	}

	public void saveAndFlush(Order order) {
		orderRepository.saveAndFlush(order);
	}

	public List<Order> findOrdersByUserAndStatus(User user, String status) {
		return orderRepository.findOrdersByUserAndStatus(user, status);
	}

}