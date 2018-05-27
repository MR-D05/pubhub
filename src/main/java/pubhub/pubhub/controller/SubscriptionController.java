package pubhub.pubhub.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pubhub.pubhub.model.Channel;
import pubhub.pubhub.model.Role;
import pubhub.pubhub.model.User;
import pubhub.pubhub.repository.RoleRepository;
import pubhub.pubhub.service.ChannelService;
import pubhub.pubhub.service.UserService;

@Controller
public class SubscriptionController {

	@Autowired
	UserService userService;

	@Autowired
	ChannelService channelService;

	@Autowired
	RoleRepository roleRepository;

	@RequestMapping(value = "/subscriptions/manage", method = RequestMethod.GET)
	public String registration(final HttpServletRequest request, final HttpServletResponse response,
			final Authentication authentication, Model model) {
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		List<User> users = userService.findAll();
		// System.out.println(users);
		List<User> authors = new ArrayList<>();
		Role authorRole = roleRepository.findByName("ROLE_AUTHOR");
		for (User u : users) {
			Collection<Role> roles = u.getRoles();
			for (Role r : roles) {
				if (r.equals((authorRole))) {
					authors.add(u);
				}
			}
		}
		model.addAttribute("currentlyLoggedOnUser", user);
		model.addAttribute("authors", authors);
		return "manageSubscriptions";
	}

	@RequestMapping(value = "/subscription/add/{authorUsername}")
	@PutMapping
	public void add(@PathVariable String authorUsername, final HttpServletRequest request,
			final HttpServletResponse response, final Authentication authentication) {
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		User author = userService.findByUsername(authorUsername);
		Channel channel = channelService.findByUser(author);
		List<Channel> subscriptions = channelService.findAll();
		for (Channel c : subscriptions) {
			if (c.getUsers().contains(user)) {
				break;
			}
		}
		user.getChannels().addAll((Arrays.asList(channel)));
		userService.save(user);
		channel.getUsers().addAll(Arrays.asList(user));
		channelService.save(channel);
	}

	@RequestMapping(value = "/subscription/delete/{authorUsername}")
	@DeleteMapping
	public void delete(@PathVariable String authorUsername, final HttpServletRequest request,
			final HttpServletResponse response, final Authentication authentication, @RequestBody String body) {
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		User author = userService.findByUsername(authorUsername);
		Channel channel = channelService.findByUser(author);
		user.getChannels().remove(channel);
		userService.save(user);
	}

}
