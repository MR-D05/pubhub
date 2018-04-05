package libraryapp.libraryapp.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import libraryapp.libraryapp.model.Item;
import libraryapp.libraryapp.model.Order;
import libraryapp.libraryapp.model.User;
import libraryapp.libraryapp.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {
	private static final Logger LOGGER = LogManager.getLogger(BookController.class);

	@Autowired
	private OrderService orderService;

	@GetMapping("/list")
	public String list(ModelMap modelMap, HttpSession session) {
		modelMap.addAttribute("MY_CHECKEDOUT_BOOKS");
		User user = (User) session.getAttribute("LOGGED_IN_USER");
		Order order = (Order) session.getAttribute("MY_CHECKEDOUT_BOOKS");
		List<Item> items = new ArrayList<>();
		if (order == null) {
			order = new Order();
			session.setAttribute("MY_CHECKEDOUT_BOOKS", order);
		}
		Long id = user.getId();
		List<Order> orders = orderService.findOrdersByUserId(id);
		for (Order o : orders) {
			if (o.getStatus().equals("CHECKEDOUT")) {
				for (Item i : o.getItems()) {
					items.add(i);
				}
		}
		order.setItems(items);
		session.setAttribute("MY_CHECKEDOUT_BOOKS", order);
		LOGGER.info(order.getItems());
		}
		return "redirect:/list.jsp";
	}

	@GetMapping("/cart")
	public String cart(HttpSession session) {
		User user = (User) session.getAttribute("LOGGED_IN_USER");
		try {
			Order order = orderService.findOrderByUserAndStatus(user, "OPEN");
			List<Item> items = order.getItems();
			session.setAttribute("MY_CART_ITEMS", order);
			return "redirect:/cart.jsp";
		} catch (NullPointerException n) {
			return "redirect:/empty.jsp";
		}
	}

	@GetMapping("/checkout")
	public String buy(HttpSession session) {
		Order order = (Order) session.getAttribute("MY_CART_ITEMS");
		order.setStatus("CHECKEDOUT");
		orderService.save(order);
		return "redirect:/checkedOut.jsp";
	}
}
