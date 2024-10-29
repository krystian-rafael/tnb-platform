package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.AssignedAttributeData;
import com.ksprogramming.tnb.Data.AttributeData;
import com.ksprogramming.tnb.Data.EquipmentData;
import com.ksprogramming.tnb.Repository.AssignedAttributeRepository;
import com.ksprogramming.tnb.Repository.AttributeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-integrationtest.properties")

class AssignedAttributeServiceTest {
    @Autowired
    private AssignedAttributeServiceInterface assignedAttributeService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private AttributeServiceInterface attributeService;

    @Autowired
    private AssignedAttributeRepository assignedAttributeRepository;

    @Autowired
    private com.ksprogramming.tnb.repository.EquipmentRepository equipmentRepository;

    @Autowired
    private AttributeRepository attributeRepository;

    @BeforeEach
    void setUp() {
        assignedAttributeRepository.deleteAll();
        equipmentRepository.deleteAll();
        attributeRepository.deleteAll();
    }

    @Test
    void create() {
        // GIVEN
        EquipmentData equipment = equipmentService.createEquipment(EquipmentData.builder()
                .name("Car")
                .type("String")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());
        AttributeData attribute = attributeService.createAttribute(AttributeData.builder()
                .name("Brand")
                .type("String")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        AssignedAttributeData assignedAttributeData = assignedAttributeService.create(AssignedAttributeData.builder()
                .equipment(equipment)
                .attribute(attribute)
                .value("Porsche")
                .build());

        // WHEN
        AssignedAttributeData result = assignedAttributeService.get(assignedAttributeData.getId());

        // EXPECTED

        assertEquals(equipment.getId(), result.getEquipment().getId());
        assertEquals(attribute.getId(), result.getAttribute().getId());
        assertEquals(attribute.getName(), result.getAttribute().getName());
        assertEquals(attribute.getType(), result.getAttribute().getType());
        assertEquals(equipment.getName(), result.getEquipment().getName());
    }

    @Test
    public void get(){
        // GIVEN
        EquipmentData equipment = equipmentService.createEquipment(EquipmentData.builder()
                .name("Car")
                .type("String")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());
        AttributeData attribute = attributeService.createAttribute(AttributeData.builder()
                .name("Brand")
                .type("String")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        AssignedAttributeData assignedAttributeData = assignedAttributeService.create(AssignedAttributeData.builder()
                .equipment(equipment)
                .attribute(attribute)
                .value("Porsche")
                .build());

        // WHEN
        AssignedAttributeData result = assignedAttributeService.get(assignedAttributeData.getId());

        // EXPECTED

        assertEquals(equipment.getId(), result.getEquipment().getId());
        assertEquals(attribute.getId(), result.getAttribute().getId());
        assertEquals(attribute.getName(), result.getAttribute().getName());
        assertEquals(attribute.getType(), result.getAttribute().getType());
        assertEquals(equipment.getName(), result.getEquipment().getName());
    }
    @Test
    public void findAll(){
        // GIVEN
        LocalDateTime time = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        EquipmentData equipment = equipmentService.createEquipment(EquipmentData.builder()
                .name("Car")
                .type("String")
                .createDate(time)
                .build());
        AttributeData attribute = attributeService.createAttribute(AttributeData.builder()
                .name("Brand")
                .type("String")
                .createDate(time)
                .build());

        AttributeData secondAttribute = attributeService.createAttribute(AttributeData.builder()
                .name("Model")
                .type("String")
                .createDate(time)
                .build());

        AssignedAttributeData assignedAttributeData = assignedAttributeService.create(AssignedAttributeData.builder()
                .equipment(equipment)
                .attribute(attribute)
                .value("Porsche")
                .build());

        AssignedAttributeData secondAssignedAttributeData = assignedAttributeService.create(AssignedAttributeData.builder()
                .equipment(equipment)
                .attribute(secondAttribute)
                .value("Cayenne")
                .build());

        // WHEN
        List<AssignedAttributeData> result = assignedAttributeService.findAll();

        // EXPECTED
        assertEquals(2, result.size());
        List<EquipmentData> equipmentList = result.stream().map(AssignedAttributeData::getEquipment).toList();
        assertEquals(2, equipmentList.size());
        List<String> name = equipmentList.stream().map(EquipmentData::getName).toList();
        assertTrue(name.contains(equipment.getName()));
        List<AttributeData> attributeList = result.stream().map(AssignedAttributeData::getAttribute).toList();
        assertEquals(2, attributeList.size());
        List<String> attributeName = attributeList.stream().map(AttributeData::getName).toList();
        assertTrue(attributeName.contains(attribute.getName()));
    }

    @Test
    void update() {
        // GIVEN
        LocalDateTime time = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        // GIVEN
        EquipmentData equipment = equipmentService.createEquipment(EquipmentData.builder()
                .name("Car")
                .type("String")
                .createDate(time)
                .build());
        AttributeData attribute = attributeService.createAttribute(AttributeData.builder()
                .name("Brand")
                .type("String")
                .createDate(time)
                .build());

        AssignedAttributeData assignedAttributeData = assignedAttributeService.create(AssignedAttributeData.builder()
                .equipment(equipment)
                .attribute(attribute)
                .value("Porsche")
                .build());

        // WHEN
        AssignedAttributeData resultBeforeUpdate = assignedAttributeService.get(assignedAttributeData.getId());
        resultBeforeUpdate.setValue("Audi");
        assignedAttributeService.update(resultBeforeUpdate);
        AssignedAttributeData resultAfterUpdate = assignedAttributeService.get(assignedAttributeData.getId());

        // EXPECTED

        assertEquals(equipment.getId(), resultAfterUpdate.getEquipment().getId());
        assertEquals(attribute.getId(), resultAfterUpdate.getAttribute().getId());
        assertEquals(attribute.getName(), resultAfterUpdate.getAttribute().getName());
        assertEquals(attribute.getType(), resultAfterUpdate.getAttribute().getType());
        assertEquals(equipment.getName(), resultAfterUpdate.getEquipment().getName());
        assertEquals("Audi", resultAfterUpdate.getValue());

    }

    @Test
    void delete() {
        // GIVEN
        LocalDateTime time = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        // GIVEN
        EquipmentData equipment = equipmentService.createEquipment(EquipmentData.builder()
                .name("Car")
                .type("String")
                .createDate(time)
                .build());
        AttributeData attribute = attributeService.createAttribute(AttributeData.builder()
                .name("Brand")
                .type("String")
                .createDate(time)
                .build());

        AttributeData secondAttribute = attributeService.createAttribute(AttributeData.builder()
                .name("Model")
                .type("String")
                .createDate(time)
                .build());


        AssignedAttributeData assignedAttributeData = assignedAttributeService.create(AssignedAttributeData.builder()
                .equipment(equipment)
                .attribute(attribute)
                .value("Porsche")
                .build());

        AssignedAttributeData secondAssignedAttribute = assignedAttributeService.create(AssignedAttributeData.builder()
                .equipment(equipment)
                .attribute(secondAttribute)
                .value("Audi")
                .build());

        // WHEN
        List<AssignedAttributeData> resultBeforeDelete = assignedAttributeService.findAll();
        assignedAttributeService.delete(secondAssignedAttribute.getId());
        List<AssignedAttributeData> resultAfterDelete = assignedAttributeService.findAll();

        // EXPECTED
        assertEquals(2, resultBeforeDelete.size());
        assertEquals(1, resultAfterDelete.size());
        List<String> values = resultAfterDelete.stream().map(AssignedAttributeData::getValue).toList();
        assertTrue(values.contains(assignedAttributeData.getValue()));
        assertFalse(values.contains(secondAssignedAttribute.getValue()));
    }





}