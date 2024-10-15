package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.EquipmentData;

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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-integrationtest.properties")
class EquipmentServiceIntegrationTest {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private com.ksprogramming.tnb.repository.EquipmentRepository equipmentRepository;

    @BeforeEach
    void setUp() {
        equipmentRepository.deleteAll();
    }

    @Test
    void createEquipment() {
        // GIVEN
        EquipmentData equipmentData = EquipmentData.builder()
                .name("Drill")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build();

        // WHEN
        EquipmentData savedEquipment = equipmentService.createEquipment(equipmentData);

        // THEN
        List<EquipmentData> results = equipmentService.findAllEquipment();
        EquipmentData result = equipmentService.getEquipmentById(savedEquipment.getId());

        assertEquals(1, results.size());
        assertNotNull(result);
        assertEquals(savedEquipment.getName(), result.getName());
        assertEquals(savedEquipment.getCreateDate(), result.getCreateDate());
        assertNull(result.getDeleteDate());
    }

    @Test
    void updateEquipment() {
        // GIVEN
        EquipmentData equipmentData = EquipmentData.builder()
                .name("Drill")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build();

        EquipmentData savedEquipment = equipmentService.createEquipment(equipmentData);

        // WHEN
        EquipmentData originalResult = equipmentService.getEquipmentById(savedEquipment.getId());
        originalResult.setName("Hammer");
        EquipmentData updatedEquipment = equipmentService.updateEquipment(originalResult);

        // THEN
        assertEquals(savedEquipment.getId(), updatedEquipment.getId());
        assertEquals("Hammer", updatedEquipment.getName());
        assertNull(updatedEquipment.getDeleteDate());
    }

    @Test
    void deleteEquipment() {
        // GIVEN
        EquipmentData equipmentData = EquipmentData.builder()
                .name("Drill")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build();

        EquipmentData savedEquipment = equipmentService.createEquipment(equipmentData);

        // WHEN
        equipmentService.deleteEquipment(savedEquipment.getId());
        Optional<EquipmentData> result = Optional.ofNullable(equipmentService.getEquipmentById(savedEquipment.getId()));

        // THEN
        assertNotNull(result.get().getDeleteDate());
    }

    @Test
    void findAllEquipment() {
        // GIVEN
        EquipmentData firstEquipment = EquipmentData.builder()
                .name("Drill")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build();

        EquipmentData secondEquipment = EquipmentData.builder()
                .name("Hammer")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build();

        equipmentService.createEquipment(firstEquipment);
        equipmentService.createEquipment(secondEquipment);

        // WHEN
        List<EquipmentData> results = equipmentService.findAllEquipment();

        // THEN
        List<String> names = new ArrayList<>();
        results.forEach(e -> names.add(e.getName()));
        assertTrue(names.contains("Drill"));
        assertTrue(names.contains("Hammer"));
    }

    @Test
    void getEquipmentById() {
        // GIVEN
        EquipmentData equipmentData = EquipmentData.builder()
                .name("Drill")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build();

        EquipmentData savedEquipment = equipmentService.createEquipment(equipmentData);

        // WHEN
        EquipmentData result = equipmentService.getEquipmentById(savedEquipment.getId());

        // THEN
        assertEquals(savedEquipment.getId(), result.getId());
        assertEquals(savedEquipment.getName(), result.getName());
        assertEquals(savedEquipment.getCreateDate(), result.getCreateDate());
    }
}
