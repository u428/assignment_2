package io.image.ulugbek.frontimage.Model.Entity;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class Photos {
    
    private int page;
    private int pages;
    private int perpage;
    private int total;
    private Photo photo[];
    
}
