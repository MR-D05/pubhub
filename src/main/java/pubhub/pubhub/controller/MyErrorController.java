package pubhub.pubhub.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

	@RequestMapping("/error")
	public String error() {
		return "redirect:/error.jsp";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}