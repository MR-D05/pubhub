//package pubhub.pubhub.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import pubhub.pubhub.model.Author;
//import pubhub.pubhub.model.Channel;
//import pubhub.pubhub.model.Subscriber;
//import pubhub.pubhub.model.User;
//import pubhub.pubhub.service.AuthorService;
//import pubhub.pubhub.service.ChannelService;
//import pubhub.pubhub.service.MessageService;
//import pubhub.pubhub.service.SubscriberService;
//import pubhub.pubhub.service.UserService;
//
//@Controller
//public class ChannelController {
//
//	@Autowired
//	UserService userService;
//
//	@Autowired
//	AuthorService authorService;
//
//	@Autowired
//	MessageService messageService;
//
//	@Autowired
//	ChannelService channelService;
//
//	@Autowired
//	SubscriberService subscriberService;
//
//	@RequestMapping("/channel/home")
//	public String channelHome(Model model, HttpSession session) {
//		
//		
//		Channel channel = channelService.fin
//		List<Message> messages = messageService.findAllByChannel()
//		
//		
//		
//		model.addAttribute("messages", messageService);
//		return "yourChannel";
//	}
//
//}
