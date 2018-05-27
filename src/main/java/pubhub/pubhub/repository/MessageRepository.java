package pubhub.pubhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pubhub.pubhub.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

	void delete(Message message);

}
