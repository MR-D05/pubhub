package libraryapp.libraryapp.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import libraryapp.libraryapp.model.Book;
import libraryapp.libraryapp.model.User;
import libraryapp.libraryapp.service.BookService;
import libraryapp.libraryapp.service.UserService;

@Controller
@RequestMapping("auth")
public class AuthController {
	private static final Logger LOGGER = LogManager.getLogger(BookController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/login")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password, ModelMap modelMap, HttpSession session) {
		User user = userService.findByNameAndPassword(name, password); 
		if (user != null) {
			session.setAttribute("LOGGED_IN_USER", user);
			List<Book> books = null;
			books = bookService.findAll();
			session.setAttribute("books", books);
			return "redirect:/libraryHome.jsp";
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