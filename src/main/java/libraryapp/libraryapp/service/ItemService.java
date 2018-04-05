package libraryapp.libraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import libraryapp.libraryapp.model.Item;
import libraryapp.libraryapp.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository orderItemRepository;

	public void save(Item item) {
		orderItemRepository.save(item);
	}
}