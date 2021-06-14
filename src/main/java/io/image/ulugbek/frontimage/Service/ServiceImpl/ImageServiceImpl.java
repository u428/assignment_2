package io.image.ulugbek.frontimage.Service.ServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.image.ulugbek.frontimage.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
//    @Cacheable(cacheNames = "allIamge", key = "#tags")
    public ResponseEntity getImages(String tags, int limit, int page){
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            ObjectMapper mapper = new ObjectMapper();
            ResponseEntity<String> a = restTemplate.exchange(
                    "https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=4a4b7c2409956a7ea742d8ae1867bf59&format=json&nojsoncallback=1" + "&tags=" + tags + "&per_page=" + limit + "&page=" + page,
                    HttpMethod.GET, entity, String.class);
            System.out.println(a.getBody());
            return a;
    }

    @Override
    public ResponseEntity getSingleImage() {
        return null;
    }

    @Override
    @Cacheable(cacheNames = "iamges", key = "#id")
    public Resource downloadImage(int farm, int server, Long id, String secret) {
        Resource image = restTemplate.getForObject("https://farm"+farm+".static.flickr.com/"+server+"/"+id+"_"+secret+"_d.jpg",Resource.class);
//        Files.write(Paths.get("image.jpg"), image);
        System.out.println("internetdan yukladi rasimi");
        return image;
    }
}
