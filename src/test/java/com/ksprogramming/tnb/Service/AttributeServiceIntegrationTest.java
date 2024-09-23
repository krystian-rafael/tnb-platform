package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.AttributeData;
import com.ksprogramming.tnb.Enumes.AttributeType;
import com.ksprogramming.tnb.Repository.AttributeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-integrationtest.properties")
class AttributeServiceIntegrationTest {
    @Autowired
    private AttributeService attributeService;
    @Autowired
    private AttributeRepository attributeRepository;
    @BeforeEach
    public void setUp() {
        attributeRepository.deleteAll();
    }

    @Test
    void createAttribute() {
        //GIVEN
        AttributeData attribute = AttributeData.builder()
                .name("Mark")
                .type(AttributeType.INT.name())
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build();
        attributeService.createAttribute(attribute);
        //WHEN
        List<AttributeData> results = attributeService.findAllAttributes();
        //EXPECTED
        Assert.assertEquals(1, results.size());
        List<String> names = new ArrayList<>();
        results.stream().forEach(attributeData -> names.add(attributeData.getName()));
        Assert.assertTrue(names.contains("Mark"));
        List<String> types = new ArrayList<>();
        results.stream().forEach(attributeData -> types.add(attributeData.getType()));
        Assert.assertTrue(types.contains(AttributeType.INT.name()));
    }

    @Test
    void updateAttribute() {
        AttributeData attribute = attributeService.createAttribute(AttributeData.builder()
                .name("Mark")
                .type(AttributeType.INT.name())
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());
        //WHEN
        AttributeData result = attributeService.findAttributeById(attribute.getId());
        //EXPECTED
        Assert.assertEquals(attribute.getName(), result.getName());
        Assert.assertEquals(attribute.getType(), result.getType());
        Assert.assertEquals(attribute.getCreateDate(), result.getCreateDate());
    }

    @Test
    void findAttributeById() {
        //GIVEN
        AttributeData attribute = attributeService.createAttribute(AttributeData.builder()
                .name("Mark")
                .type(AttributeType.INT.name())
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());
        //WHEN
        AttributeData result = attributeService.findAttributeById(attribute.getId());
        //EXPECTED
        Assert.assertEquals(attribute.getName(), result.getName());
        Assert.assertEquals(attribute.getType(), result.getType());
        Assert.assertEquals(attribute.getCreateDate(), result.getCreateDate());
    }

    @Test
    void findAllAttributes() {
        //GIVEN
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        AttributeData attributeDataFirst = new AttributeData("Model", AttributeType.INT.name(), now);
        attributeService.createAttribute(attributeDataFirst);
        AttributeData attributeDataSecond = new AttributeData("Brand", AttributeType.STRING.name(), now);
        attributeService.createAttribute(attributeDataSecond);

        //WHEN
        List<AttributeData> results = attributeService.findAllAttributes();

        //EXPECTED
        Assert.assertEquals(2, results.size());
        List<String> names = new ArrayList<>();
        results.stream().forEach(attributeData -> names.add(attributeData.getName()));
        Assert.assertTrue(names.contains("Model"));
        Assert.assertTrue(names.contains("Brand"));
        List<String> types = new ArrayList<>();
        results.stream().forEach(attributeData -> types.add(attributeData.getType()));
        Assert.assertTrue(types.contains(AttributeType.STRING.name()));
        Assert.assertTrue(types.contains(AttributeType.INT.name()));
        List<LocalDateTime> dates = new ArrayList<>();
        results.stream().forEach(attributeData -> dates.add(attributeData.getCreateDate()));
        Assert.assertTrue(dates.contains(now));
    }
    @Test
    void deleteAttributeById(){
        //GIVEN
        AttributeData attributeFirst = attributeService.createAttribute(AttributeData.builder()
                .name("Mark")
                .type(AttributeType.INT.name())
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());
        AttributeData attributeSecond = attributeService.createAttribute(AttributeData.builder()
                .name("Branch")
                .type(AttributeType.STRING.name())
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());
        attributeService.deleteAttributeById(attributeSecond.getId());
        //WHEN
        List<AttributeData> results = attributeService.findAllAttributes();
        //EXPECTED
        Assert.assertEquals(1, results.size());
        List<String> names = new ArrayList<>();
        results.stream().forEach(attributeData -> names.add(attributeData.getName()));
        Assert.assertFalse(names.contains(attributeSecond.getName()));

    }
}