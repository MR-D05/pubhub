package pubhub.pubhub.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pubhub.pubhub.model.Book;
import pubhub.pubhub.model.Channel;
import pubhub.pubhub.model.Role;
import pubhub.pubhub.model.User;
import pubhub.pubhub.repository.RoleRepository;
import pubhub.pubhub.repository.UserRepository;
import pubhub.pubhub.service.BookService;
import pubhub.pubhub.service.ChannelService;
import pubhub.pubhub.service.UserService;

@Controller
public class BookController {

	private static final Logger LOGGER = LogManager.getLogger(BookController.class);
	private static String UPLOADED_FOLDER = "C:/Revature/pubhub/pubhub/books/";

	@Autowired
	UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookService bookService;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ChannelService channelService;

	@GetMapping("/download")
	public String download(@RequestParam("isbn13") String isbn13, HttpServletResponse response, HttpSession session)
			throws IOException {

		Book book = bookService.findOne(isbn13);
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + book.getTitle() + ".pdf");
		InputStream is = new ByteArrayInputStream(book.getContent());
		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[1024];
		while (is.read(buffer) != -1) {
			os.write(buffer);
		}
		os.flush();
		os.close();
		is.close();
		return isbn13;
	}

	@RequestMapping("/book/add")
	public String addBook(@RequestParam("isbn13") String isbn13, @RequestParam("title") String title,
			@RequestParam("author") String author, @RequestParam("content") MultipartFile content,
			RedirectAttributes redirectAttributes, ModelMap modelMap, HttpSession session) {
		if (content.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:/updateStatus";
		}
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentPrincipalName = authentication.getName();
			User user = userService.findByUsername(currentPrincipalName);

			Book book = new Book();
			book.setIsbn13(isbn13);
			book.setTitle(title);
			book.setAuthorname(author);
			book.setUser(user);
			byte[] bytes = content.getBytes();
			book.setContent(bytes);
			bookService.save(book);
			Path path = Paths.get(UPLOADED_FOLDER + content.getOriginalFilename());
			Files.write(path, bytes);
			List<Book> books = null;
			books = bookService.findAll();
			session.setAttribute("books", books);
			Role authorRole = roleRepository.findByName("ROLE_AUTHOR");
			Collection<Role> roles = user.getRoles();
			for (Role r : roles) {
				if (r.equals(authorRole)) {
					return "redirect:/pubHubHome.jsp";
				}
			}
			user.getRoles().addAll(Arrays.asList(authorRole));
			userRepository.saveAndFlush(user);
			Channel channel = new Channel();
			channel.setUser(user);
			channelService.save(channel);
			return "/pubHub/home";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/pubHub/home";
	}

}
