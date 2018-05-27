//package pubhub.pubhub;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import pubhub.pubhub.model.Privilege;
//import pubhub.pubhub.model.Role;
//import pubhub.pubhub.model.User;
//import pubhub.pubhub.repository.PrivilegeRepository;
//import pubhub.pubhub.repository.RoleRepository;
//import pubhub.pubhub.repository.UserRepository;
//
//@Component
//public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
//
//	boolean alreadySetup = false;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private RoleRepository roleRepository;
//
//	@Autowired
//	private PrivilegeRepository privilegeRepository;
//
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	@Override
//	@Transactional
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//
//		if (alreadySetup)
//			return;
//		Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
//		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
//
//		List<Privilege> authorPrivileges = Arrays.asList(readPrivilege, writePrivilege);
//		createRoleIfNotFound("ROLE_ADMIN", authorPrivileges);
//		createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
//		createRoleIfNotFound("ROLE_AUTHOR", authorPrivileges);
//
//		Role userRole = roleRepository.findByName("ROLE_USER");
//
//		User user = new User();
//		user.setFirstname("John");
//		user.setLastname("Jingleheimer-Schmidt");
//		user.setUsername("testuser");
//		user.setPassword(bCryptPasswordEncoder.encode("password"));
//		user.setRoles(Arrays.asList(userRole));
//		user.setEnabled(true);
//		userRepository.save(user);
//
//		User user1 = new User();
//		user1.setFirstname("Jane");
//		user1.setLastname("Rumhauser");
//		user1.setUsername("testuser1");
//		user1.setPassword(bCryptPasswordEncoder.encode("password"));
//		user1.setRoles(Arrays.asList(userRole));
//		user1.setEnabled(true);
//		userRepository.save(user1);
//
//		User user11 = new User();
//		user11.setFirstname("Lana");
//		user11.setLastname("Schmere");
//		user11.setUsername("testuser2");
//		user11.setPassword(bCryptPasswordEncoder.encode("password"));
//		user11.setRoles(Arrays.asList(userRole));
//		user11.setEnabled(true);
//		userRepository.save(user11);
//
//		alreadySetup = true;
//	}
//
//	@Transactional
//	private Privilege createPrivilegeIfNotFound(String name) {
//
//		Privilege privilege = privilegeRepository.findByName(name);
//		if (privilege == null) {
//			privilege = new Privilege(name);
//			privilegeRepository.save(privilege);
//		}
//		return privilege;
//	}
//
//	@Transactional
//	private Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
//
//		Role role = roleRepository.findByName(name);
//		if (role == null) {
//			role = new Role(name);
//			role.setPrivileges(privileges);
//			roleRepository.save(role);
//		}
//		return role;
//	}
//
//}
