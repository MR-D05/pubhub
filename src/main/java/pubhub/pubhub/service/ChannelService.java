package pubhub.pubhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pubhub.pubhub.model.Channel;
import pubhub.pubhub.model.User;
import pubhub.pubhub.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepository;

	public Channel save(Channel channel) {
		return channelRepository.save(channel);
	}

	public Channel findChannelById(Long channelid) {
		return channelRepository.findChannelById(channelid);
	}

	public Channel findByUser(User user) {
		return channelRepository.findByUser(user);
	}

	public List<Channel> findAll() {
		return channelRepository.findAll();
	}

}
