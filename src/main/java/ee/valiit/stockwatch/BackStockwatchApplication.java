package ee.valiit.stockwatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BackStockwatchApplication {



	public static void main(String[] args) {
		SpringApplication.run(BackStockwatchApplication.class, args);

	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


}
