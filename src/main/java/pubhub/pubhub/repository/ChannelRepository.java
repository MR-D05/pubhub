package pubhub.pubhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pubhub.pubhub.model.Channel;
import pubhub.pubhub.model.User;

public interface ChannelRepository extends JpaRepository<Channel, Long> {

	Channel findChannelById(Long channelid);

	Channel findByUser(User author);

}
