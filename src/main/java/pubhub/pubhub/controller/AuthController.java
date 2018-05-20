package pubhub.pubhub.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pubhub.pubhub.model.Book;
import pubhub.pubhub.model.User;
import pubhub.pubhub.service.BookService;
import pubhub.pubhub.service.UserService;

@Controller
@RequestMapping("auth")
public class AuthController {
	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@PostMapping("/login")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password, ModelMap modelMap,
			HttpSession session) {
		User user = userService.findByUserameAndPassword(name, password);
		if (user != null) {
			session.setAttribute("LOGGED_IN_USER", user);
			List<Book> books = null;
			books = bookService.findAll();
			session.setAttribute("books", books);
			return "redirect:/pubHubHome.jsp";
		} else {
			modelMap.addAttribute("ERROR_MESSAGE", "Invalid Credentials.");
			return "home";
		}
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}