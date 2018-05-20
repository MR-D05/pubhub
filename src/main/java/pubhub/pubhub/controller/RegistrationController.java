package pubhub.pubhub.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;

import pubhub.pubhub.model.Privilege;
import pubhub.pubhub.model.User;

@Controller
public class RegistrationController {

	private static final Logger LOGGER = LogManager.getLogger(RegistrationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	public RegistrationController() {
		super();
	}

//	public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
//		try {
//			request.login(username, password);
//		} catch (ServletException e) {
//			LOGGER.error("Error while login ", e);
//		}
//	}

	public void authWithAuthManager(HttpServletRequest request, String username, String password) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
		authToken.setDetails(new WebAuthenticationDetails(request));
		Authentication authentication = authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
		// SecurityContextHolder.getContext());
	}

	public void authWithoutPassword(User user) {
		List<Privilege> privileges = user.getRoles().stream().map(role -> role.getPrivileges())
				.flatMap(list -> list.stream()).distinct().collect(Collectors.toList());
		List<GrantedAuthority> authorities = privileges.stream().map(p -> new SimpleGrantedAuthority(p.getName()))
				.collect(Collectors.toList());
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}
