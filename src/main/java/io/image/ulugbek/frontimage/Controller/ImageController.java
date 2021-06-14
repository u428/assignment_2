package io.image.ulugbek.frontimage.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.image.ulugbek.frontimage.Model.Entity.Objects;
import io.image.ulugbek.frontimage.Service.ImageService;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping(path = "/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping(path = "/getImages")
    public   ResponseEntity<Objects> getImages(@RequestParam String tags, @RequestParam int limit, @RequestParam int page ) throws JsonProcessingException {
        return imageService.getImages(tags, limit, page);
    }

    @GetMapping(path = "/getSingleimage")
    private ResponseEntity getSingleImage(){
        return imageService.getSingleImage();
    }

    @GetMapping(path = "/downloadImage")
    public ResponseEntity donloadImage(@RequestParam int farm,@RequestParam int server, @RequestParam Long id, @RequestParam String secret,  HttpServletRequest request){
        Resource resource = imageService.downloadImage(farm, server, id, secret);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(MediaType.IMAGE_JPEG_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName="+resource.getFilename())
                .body(resource);
    }

    @GetMapping(path = "/showImage")
    public ResponseEntity showImage(@RequestParam int farm,@RequestParam int server, @RequestParam Long id, @RequestParam String secret,  HttpServletRequest request){
        Resource resource = imageService.downloadImage(farm, server, id, secret);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(MediaType.IMAGE_JPEG_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName="+resource.getFilename())
//                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName="+resource.getFilename())
                .body(resource);
    }

}
