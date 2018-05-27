package pubhub.pubhub.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pubhub.pubhub.model.Book;
import pubhub.pubhub.model.Item;
import pubhub.pubhub.model.Order;
import pubhub.pubhub.model.User;
import pubhub.pubhub.service.OrderService;
import pubhub.pubhub.service.UserService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@RequestMapping("/order/list")
	@GetMapping
	public String list(HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		System.out.println(user);
		List<Item> items = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		List<Order> orders = orderService.findOrdersByUserAndStatus(user, "CHECKEDOUT");
		System.out.println(orders);
		for (Order order : orders) {
			items.addAll(order.getItems());
			for (Item item : items) {
				books.add(item.getBook());
			}
		}
		session.setAttribute("books", books);
		return "redirect:/list.jsp";
	}

	@RequestMapping("/order/cart")
	@GetMapping
	public String cart(HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		try {
			Order order = orderService.findOrderByUserAndStatus(user, "OPEN");
			List<Item> items = order.getItems();
			session.setAttribute("items", items);
			return "redirect:/cart.jsp";
		} catch (NullPointerException n) {
			return "redirect:/empty.jsp";
		}
	}

	@RequestMapping("/order/checkout")
	@GetMapping
	public String buy(HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		Order order = orderService.findOrderByUserAndStatus(user, "OPEN");
		order.setStatus("CHECKEDOUT");
		orderService.save(order);
		return "redirect:/checkedOut.jsp";
	}

}
