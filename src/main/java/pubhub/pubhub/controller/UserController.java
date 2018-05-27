package pubhub.pubhub.controller;

import java.util.Arrays;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pubhub.pubhub.model.Role;
import pubhub.pubhub.model.User;
import pubhub.pubhub.repository.RoleRepository;
import pubhub.pubhub.security.ActiveUserStore;
import pubhub.pubhub.service.UserService;
import pubhub.pubhub.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	ActiveUserStore activeUserStore;

	@Autowired
	UserService userService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("registrationForm", new User());
		return "registration";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("registrationForm") User registrationForm, BindingResult bindingResult,
			Model model) {
		userValidator.validate(registrationForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/user/register";
		}
		registrationForm.setPassword(bCryptPasswordEncoder.encode(registrationForm.getPassword()));
		registrationForm
				.setPasswordconfirmation(bCryptPasswordEncoder.encode(registrationForm.getPasswordconfirmation()));
		Role userRole = roleRepository.findByName("ROLE_USER");
		registrationForm.setRoles(Arrays.asList(userRole));
		registrationForm.setEnabled(true);
		userService.save(registrationForm);
		return "redirect:/user/login";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("loginForm", new User());
		return "login";
	}

	@RequestMapping(value = "/author/details", method = RequestMethod.GET)
	public String authorDetails(@RequestParam("username") String username, RedirectAttributes redirectAttributes,
			HttpSession session, Model model) {
		User author = userService.findByUsername(username);
		model.addAttribute("author", author);
		return "authorDetails";
	}

	@RequestMapping(value = "/currentlyLoggedInUsers", method = RequestMethod.GET)
	public String getCurrentlyLoggedInUsers(Locale locale, Model model) {
		model.addAttribute("users", activeUserStore.getUsers());
		return "currentlyLoggedInUsers";
	}

}