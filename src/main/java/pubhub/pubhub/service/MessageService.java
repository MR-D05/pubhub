package pubhub.pubhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pubhub.pubhub.model.Message;
import pubhub.pubhub.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public Message save(Message message) {
		return messageRepository.save(message);
	}

	public void delete(Message message) {
		messageRepository.delete(message);
	}

	public Message getOne(Long id) {
		return messageRepository.getOne(id);
	}

}
