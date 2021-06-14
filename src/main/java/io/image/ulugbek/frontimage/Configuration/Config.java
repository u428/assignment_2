package io.image.ulugbek.frontimage.Configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class Config {

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder
//                .setConnectTimeout(Duration.ofMillis(100))
                .build();
    }
}
