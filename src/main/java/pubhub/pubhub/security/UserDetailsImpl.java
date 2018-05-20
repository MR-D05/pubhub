package pubhub.pubhub.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pubhub.pubhub.model.User;

public class UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	private Collection<? extends GrantedAuthority> authorities;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getUsername();
	}

	public boolean isAccountNonExpired() {
		return user.isAccountNonExpired();
	}

	public boolean isAccountNonLocked() {
		return user.isAccountNonLocked();
	}

	public boolean isCredentialsNonExpired() {
		return user.isCredentialsNonExpired();
	}

	public boolean isEnabled() {
		return user.isAccountEnabled();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> collection) {
		this.authorities = collection;
	}

}