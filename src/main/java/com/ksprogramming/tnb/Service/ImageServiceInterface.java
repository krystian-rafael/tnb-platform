package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.ImageData;
import com.ksprogramming.tnb.Entity.Image;

import java.util.List;

public interface ImageServiceInterface {
    ImageData createImagePath(String path);
    ImageData getImagePath(Long id);
    List<ImageData> findAllImages();
    void deleteImagePath(Long id);
    void updateImagePath(ImageData imageData);
}
