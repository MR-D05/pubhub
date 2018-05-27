package pubhub.pubhub.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pubhub.pubhub.model.Book;
import pubhub.pubhub.model.Item;
import pubhub.pubhub.model.Order;
import pubhub.pubhub.model.User;
import pubhub.pubhub.service.BookService;
import pubhub.pubhub.service.ItemService;
import pubhub.pubhub.service.OrderService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private BookService bookService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ItemService itemService;

	@PostMapping("/add")
	public String add(@RequestParam("isbn13") String isbn13, RedirectAttributes redirectAttributes,
			HttpSession session) {
		User user = (User) session.getAttribute("LOGGED_IN_USER");
		try {
			Order order = orderService.findOrderByUserAndStatus(user, "OPEN");
			List<Item> items = order.getItems();
			Item item = new Item();
			Book book = bookService.findOne(isbn13);
			item.setOrder(order);
			item.setBook(book);
			itemService.save(item);
			items.add(item);
			order.setItems(items);
			orderService.save(order);
			session.setAttribute("MY_CART_ITEMS", order);
			return "redirect:/success.jsp";
		} catch (NullPointerException n) {
			Order order = new Order();
			order.setUser(user);
			order.setStatus("OPEN");
			orderService.save(order);
			Item item = new Item();
			Book book = bookService.findOne(isbn13);
			item.setOrder(order);
			item.setBook(book);
			itemService.save(item);
			session.setAttribute("MY_CART_ITEMS", order);
			return "redirect:/success.jsp";
		}
	}

	@GetMapping("/list")
	public String list(HttpSession session) {
		return null;
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("isbn13") String isbn13, HttpSession session) {
		User user = (User) session.getAttribute("LOGGED_IN_USER");
		try {
			Order order = orderService.findOrderByUserAndStatus(user, "OPEN");
			List<Item> items = order.getItems();
			for (@SuppressWarnings("unused")
			Item item : items) {
				order.removeItem(isbn13);
				orderService.saveAndFlush(order);
				return "redirect:/removed.jsp";
			}
			return "redirect:/removed.jsp";
		} catch (Exception e) {
			return "redirect:/cart.jsp";
		}
	}
}
