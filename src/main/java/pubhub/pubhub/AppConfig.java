package pubhub.pubhub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pubhub.pubhub.security.ActiveUserStore;

@Configuration
public class AppConfig {

	@Bean
	public ActiveUserStore activeUserStore() {
		return new ActiveUserStore();
	}
	
}