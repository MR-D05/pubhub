package pubhub.pubhub.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pubhub.pubhub.model.Author;
import pubhub.pubhub.model.User;
import pubhub.pubhub.service.AuthorService;

@Controller
@RequestMapping("social")
public class FanOutreachController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/home")
	public String list(HttpSession session) {
		User user = (User) session.getAttribute("LOGGED_IN_USER");
		try {
			Author author = authorService.findAuthorByUser(user);
			if(author != null) {
				return "redirect:/channels.jsp";
			} else {
				return "redirect:/addAuthor.jsp";
			}
		} catch (NullPointerException n) {
			return "redirect:/error.jsp";
		}
	}
}
