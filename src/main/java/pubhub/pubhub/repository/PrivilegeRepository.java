package pubhub.pubhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pubhub.pubhub.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

	public Privilege findByName(String name);

}
