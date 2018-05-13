package pubhub.pubhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pubhub.pubhub.model.Item;

public interface ItemRepository  extends JpaRepository<Item, Long>  {

}
