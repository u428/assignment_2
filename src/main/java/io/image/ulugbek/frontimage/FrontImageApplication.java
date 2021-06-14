package io.image.ulugbek.frontimage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class FrontImageApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontImageApplication.class, args);
	}


}
