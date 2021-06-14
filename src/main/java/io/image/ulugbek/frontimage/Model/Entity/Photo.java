package io.image.ulugbek.frontimage.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Photo {

    private Long id;
    private String owner;
    private String secret;
    private int server;
    private String title;
    @JsonIgnore
    private int ispublic;
    @JsonIgnore
    private int isfriend;
    @JsonIgnore
    private int isfamily;
}
