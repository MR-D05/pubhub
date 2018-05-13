package pubhub.pubhub.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pubhub.pubhub.model.Book;
import pubhub.pubhub.repository.BookRepository;
import pubhub.pubhub.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {
	private static final Logger LOGGER = LogManager.getLogger(BookController.class);
	private static String UPLOADED_FOLDER = "/Users/bbroadstone/Documents/Library/libraryapp/books/";

	@Autowired
	private BookService bookService;

	@Autowired
	private BookRepository bookRepository;
	private Book book = new Book();

	@GetMapping("/list")
	public String list(HttpSession session) {
		LOGGER.info("Entering list");
		List<Book> books = null;
		books = bookService.findAll();
		LOGGER.info(books);
		session.setAttribute("books", books);
		return "/libraryHome.jsp";
	}

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

	@PostMapping("/add")
	public String addBook(@RequestParam("isbn13") String isbn13, @RequestParam("title") String title,
			@RequestParam("author") String author, @RequestParam("content") MultipartFile content,
			RedirectAttributes redirectAttributes, ModelMap modelMap, HttpSession session) {
		if (content.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:/updateStatus";
		}
		try {
			Book book = new Book();
			book.setIsbn13(isbn13);
			book.setTitle(title);
			book.setAuthor(author);
			byte[] bytes = content.getBytes();
			book.setContent(bytes);
			bookService.save(book);
			Path path = Paths.get(UPLOADED_FOLDER + content.getOriginalFilename());
			Files.write(path, bytes);
			LOGGER.info("Entering list");
			List<Book> books = null;
			books = bookService.findAll();
			LOGGER.info(books);
			session.setAttribute("books", books);
			return "redirect:/libraryHome.jsp";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/libraryHome.jsp";
	}

}
