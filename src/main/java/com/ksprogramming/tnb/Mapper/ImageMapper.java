package com.ksprogramming.tnb.Mapper;

import com.ksprogramming.tnb.Data.ImageData;
import com.ksprogramming.tnb.Entity.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageMapper {
    public static ImageData EntityToData(Image image) {
        return ImageData.builder()
                .id(image.getId())
                .path(image.getPath())
                .createDate(image.getCreateDate())
                .updateDate(image.getUpdateDate())
                .deleteDate(image.getDeleteDate())
                .build();
    }
    public static List<ImageData> EntitiesToData(List<Image> images) {
        List<ImageData> imagesData = new ArrayList<>();
        images.forEach(image -> {imagesData.add(new ImageData(image.getId(),
                image.getPath(), image.getCreateDate(), image.getUpdateDate()));});
    return imagesData;
    }
    public static Image DataToEntity(ImageData imageData) {
        return Image.builder()
                .id(imageData.getId())
                .path(imageData.getPath())
                .createDate(imageData.getCreateDate())
                .updateDate(imageData.getUpdateDate())
                .deleteDate(imageData.getDeleteDate())
                .build();
        }
}
