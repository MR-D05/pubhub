package libraryapp.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import libraryapp.libraryapp.model.Item;

public interface ItemRepository  extends JpaRepository<Item, Long>  {

}
