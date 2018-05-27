package pubhub.pubhub.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pubhub.pubhub.model.Channel;
import pubhub.pubhub.model.Message;
import pubhub.pubhub.model.Role;
import pubhub.pubhub.model.User;
import pubhub.pubhub.repository.RoleRepository;
import pubhub.pubhub.service.ChannelService;
import pubhub.pubhub.service.MessageService;
import pubhub.pubhub.service.UserService;

@Controller
public class MessageController {

	@Autowired
	UserService userService;

	@Autowired
	ChannelService channelService;

	@Autowired
	MessageService messageService;

	@Autowired
	RoleRepository roleRepository;

	@RequestMapping(value = "/message/list", method = RequestMethod.GET)
	public String list(Model model, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		List<Message> messages = user.getMessages();
		model.addAttribute("messages", messages);
		return "messageList";
	}

	@RequestMapping(value = "/message/send", method = RequestMethod.GET)
	public String sendMessage(Model model, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		Role authorRole = roleRepository.findByName("ROLE_AUTHOR");
		Collection<Role> roles = user.getRoles();
		if (!roles.contains(authorRole)) {
			return "notAnAuthor";
		}
		Channel channel = channelService.findByUser(user);
		System.out.println(channel);
		Collection<User> users = channel.getUsers();
		System.out.println(users);
		model.addAttribute("users", users);
		return "sendMessage";
	}

	@RequestMapping(value = "/message/send", method = RequestMethod.POST)
	public String sendMessage(@RequestParam("userid") Long userid, @RequestParam("content") String content) {
		System.out.println(userid);
		System.out.println(content);
		Message message = new Message();
		User user = userService.getOne(userid);
		message.setUser(user);
		message.setContent(content);
		messageService.save(message);
		return "redirect:/socialHome.jsp";
	}

	@RequestMapping(value = "/message/delete/{id}")
	@DeleteMapping
	public void deleteMessage(@PathVariable Long id, final HttpServletRequest request,
			final HttpServletResponse response, final Authentication authentication, @RequestBody String body) {
		System.out.println(id);
		Message message = messageService.getOne(id);
		System.out.println(message);
		messageService.delete(message);
	}

}
