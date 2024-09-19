package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.ImageData;
import com.ksprogramming.tnb.Entity.Image;
import com.ksprogramming.tnb.Exception.NoImagePathException;
import com.ksprogramming.tnb.Exception.WrongImageType;
import com.ksprogramming.tnb.Mapper.ImageMapper;
import com.ksprogramming.tnb.Repository.ImageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
public class ImageService implements ImageServiceInterface{
    ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public ImageData createImagePath(String path) {
        return ImageMapper.EntityToData(imageRepository.save(new Image(validateJpegType(path), LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))));
    }

    public ImageData getImagePath(Long id) {
        return ImageMapper.EntityToData(imageRepository.findById(id).orElseThrow(() -> new NoImagePathException("No image found with id: " + id)));
    }
    public List<ImageData> findAllImages() {
        return ImageMapper.EntitiesToData(imageRepository.findAll());
    }
    public void updateImagePath(ImageData imageData) {
        imageRepository.save(ImageMapper.DataToEntity(imageData));

    }
    @Transactional
    public void deleteImagePath(Long id) {
        ImageData imageData = getImagePath(id);
        imageData.setDeleteDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        updateImagePath(imageData);
    }
    private String validateJpegType(String path){
        String[] type = path.split("\\.");
        if (type[1].equals("jpeg") || type[1].equals("jpg")) {
            if (type[1].equals("jpeg")) {
                return type[0] + "." + type[1];
            } else if (type[1].equals("jpg")) {
                String replaceType = type[1].replace("jpg", "jpeg");
                type[1] = replaceType;
                return type[0] + "." + type[1];
            }
        }
            throw new WrongImageType("Just jpeg or JPG image");
    }
}
