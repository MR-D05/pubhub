package pubhub.pubhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pubhub.pubhub.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByName(String string);

}
