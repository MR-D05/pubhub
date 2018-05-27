package pubhub.pubhub.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pubhub.pubhub.model.Book;
import pubhub.pubhub.service.BookService;
import pubhub.pubhub.service.UserService;

@Controller
public class HomeController {

	@Autowired
	BookService bookService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/pubHub/home", method = RequestMethod.GET)
	public String pubHubHome(final HttpServletRequest request, final HttpServletResponse response,
			final Authentication authentication, HttpSession session, Model model) {
		List<Book> books = new ArrayList<>();
		books = bookService.findAll();
		session.setAttribute("books", books);
		return "pubHubHome";
	}

	@RequestMapping(value = "/social/home", method = RequestMethod.GET)
	public String socialHome(final HttpServletRequest request, final HttpServletResponse response,
			final Authentication authentication, Model model) {
		return "socialHome";
	}

}