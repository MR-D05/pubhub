package pubhub.pubhub.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "passwordconfirmation")
	private String passwordconfirmation;

	private boolean enabled;

	private boolean tokenExpired;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isTokenExpired() {
		return tokenExpired;
	}

	public void setTokenExpired(boolean tokenExpired) {
		this.tokenExpired = tokenExpired;
	}

	public String getPasswordconfirmation() {
		return passwordconfirmation;
	}

	public void setPasswordconfirmation(String passwordconfirmation) {
		this.passwordconfirmation = passwordconfirmation;
	}

	@ManyToMany
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
	private Collection<Role> roles;

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(List<Role> list) {
		this.roles = list;
	}

	public User(Long id, String username, String password, String passwordconfirmation, boolean enabled,
			boolean tokenExpired, Collection<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordconfirmation = passwordconfirmation;
		this.enabled = enabled;
		this.tokenExpired = tokenExpired;
		this.roles = roles;
	}

	public User() {
		super();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
}