package pubhub.pubhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pubhub.pubhub.model.Item;
import pubhub.pubhub.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public void save(Item item) {
		itemRepository.save(item);
	}

	public void delete(Item item) {
		itemRepository.delete(item);
	}

}