package io.image.ulugbek.frontimage.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface ImageService {
    ResponseEntity getImages(String tags, int limit, int page) throws JsonProcessingException;

    ResponseEntity getSingleImage();

    Resource downloadImage(int farm, int server, Long id, String secret);
}
