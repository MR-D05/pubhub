package pubhub.pubhub.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
import pubhub.pubhub.service.UserService;

@Controller
public class ItemController {

	@Autowired
	private BookService bookService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/item/add")
	@PostMapping
	public String add(@RequestParam("isbn13") String isbn13, RedirectAttributes redirectAttributes,
			HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
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
			session.setAttribute("items", items);
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
			List<Item> items = order.getItems();
			session.setAttribute("items", items);
			return "redirect:/success.jsp";
		}
	}

	@RequestMapping(value = "/item/remove/{isbn13}")
	@PostMapping
	public String removeItem(@PathVariable String isbn13, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		Order order = orderService.findOrderByUserAndStatus(user, "OPEN");
		System.out.println(order);
		System.out.println(order.getItems());
		Item item = new Item();
		List<Item> items = order.getItems();
		for (Item i : items) {
			if (i.getBook().getIsbn13().equals(isbn13)) {
				item = i;
			}
		}
		order.getItems().removeAll(Arrays.asList(item));
		orderService.saveAndFlush(order);
		return "redirect:/removed.jsp";
	}

}
