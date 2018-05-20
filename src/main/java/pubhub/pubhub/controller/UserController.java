package pubhub.pubhub.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pubhub.pubhub.model.User;
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

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("registrationForm", new User());
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("registrationForm") User registrationForm, BindingResult bindingResult,
			Model model) {
		userValidator.validate(registrationForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		userService.save(registrationForm);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("loginForm", new User());
		return "login";
	}

	@RequestMapping(value = "/currentlyLoggedInUsers", method = RequestMethod.GET)
	public String getCurrentlyLoggedInUsers(Locale locale, Model model) {
		model.addAttribute("users", activeUserStore.getUsers());
		return "CurrentlyLoggedInUsers";
	}
}