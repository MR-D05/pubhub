package libraryapp.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import libraryapp.libraryapp.repository.UserRepository;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/login")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password) {
		userRepository.findByNameAndPassword(name, password);
		return "redirect:/libraryHome.jsp";
	}
}
