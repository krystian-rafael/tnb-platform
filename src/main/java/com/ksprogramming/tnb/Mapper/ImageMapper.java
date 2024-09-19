package com.ksprogramming.tnb.Mapper;

import com.ksprogramming.tnb.Data.ImageData;
import com.ksprogramming.tnb.Entity.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageMapper {
    public static ImageData EntityToData(Image image) {
        return new ImageData(image.getId(), image.getPath(), image.getCreateDate(), image.getUpdateDate(), image.getDeleteDate());
    }
    public static List<ImageData> EntitiesToData(List<Image> images) {
        List<ImageData> imagesData = new ArrayList<>();
        images.forEach(image -> {imagesData.add(new ImageData(image.getId(),
                image.getPath(), image.getCreateDate(), image.getUpdateDate()));});
    return imagesData;
    }
    public static Image DataToEntity(ImageData imageData) {
        return new Image(imageData.getId(), imageData.getPath(), imageData.getCreateDate(), imageData.getUpdateDate(), imageData.getDeleteDate());
    }
}
