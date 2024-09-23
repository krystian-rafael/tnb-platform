package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.ImageData;
import com.ksprogramming.tnb.Repository.ImageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-integrationtest.properties")
class ImageServiceIntegrationTest {
    @Autowired
    private ImageServiceInterface imageService;
    @Autowired
    private ImageRepository imageRepository;
    @BeforeEach
    public void setUp() {
        imageRepository.deleteAll();
    }
    @Test
    void createImagePath() {
        //GIVEN
        ImageData imageData = imageService.createImagePath("dwa.jpg");
        //WHEN
        List<ImageData> results = imageService.findAllImages();
        //EXPECTED
        assertEquals(1, results.size());
        ImageData foundImage = imageService.getImagePath(imageData.getId());
        assertNotNull(foundImage);
        assertEquals(imageData.getId(), foundImage.getId());
        assertEquals(imageData.getPath(), foundImage.getPath());
        assertEquals(imageData.getCreateDate(), foundImage.getCreateDate());
    }

    @Test
    void getImagePath() {
        //GIVEN
        ImageData imageData = imageService.createImagePath("dwa.jpeg");
        //WHEN
        List<ImageData> results = imageService.findAllImages();
        //EXPECTED
        assertEquals(1, results.size());
        ImageData foundImage = imageService.getImagePath(imageData.getId());
        assertNotNull(foundImage);
        assertEquals(imageData.getId(), foundImage.getId());
        assertEquals(imageData.getPath(), foundImage.getPath());
        assertEquals(imageData.getCreateDate(), foundImage.getCreateDate());

    }

    @Test
    void findAllImages() {
        //GIVEN
        ImageData imageData = imageService.createImagePath("dwa.jpeg");
        ImageData imageDataSecond = imageService.createImagePath("trzy.jpeg");
        ImageData imageDataThird = imageService.createImagePath("cztery.jpeg");
        //WHEN
        List<ImageData> results = imageService.findAllImages();
        //EXPECTED
        assertEquals(3, results.size());
        List<String> path = results.stream().map(ImageData::getPath).toList();
        assertTrue(path.contains("dwa.jpeg"));
        assertTrue(path.contains("trzy.jpeg"));
        assertTrue(path.contains("cztery.jpeg"));
        List<LocalDateTime> createDateTime = results.stream().map(ImageData::getCreateDate).toList();
        assertTrue(createDateTime.contains(imageData.getCreateDate()));
        assertTrue(createDateTime.contains(imageDataSecond.getCreateDate()));
        assertTrue(createDateTime.contains(imageDataThird.getCreateDate()));

    }

    @Test
    void updateImagePath() {
        //GIVEN
        ImageData imageData = imageService.createImagePath("dwa.jpeg");
        imageData.setPath("trzy.jpeg");
        imageService.updateImagePath(imageData);
        //WHEN
        ImageData foundImage = imageService.getImagePath(imageData.getId());
        //EXPECTED
        assertEquals("trzy.jpeg", foundImage.getPath());
        assertNull(foundImage.getDeleteDate());
    }

    @Test
    void deleteImagePath() {
        //GIVEN
        ImageData imageData = imageService.createImagePath("dwa.jpeg");
        ImageData imageDataSecond = imageService.createImagePath("trzy.jpeg");
        imageService.deleteImagePath(imageData.getId());
        //EXPECTED
        ImageData foundImage = imageService.getImagePath(imageData.getId());
        List<ImageData> results = imageService.findAllImages();
        //EXPECTED
        assertEquals(1, results.size());
        assertNotNull(foundImage.getDeleteDate());
        assertEquals(imageData.getId(), foundImage.getId());
        assertEquals(imageData.getPath(), foundImage.getPath());
        assertEquals(imageData.getCreateDate(), foundImage.getCreateDate());

    }
}