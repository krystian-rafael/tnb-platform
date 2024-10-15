package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.EquipmentData;
import com.ksprogramming.tnb.Entity.Equipment;
import com.ksprogramming.tnb.Mapper.EquipmentMapper;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipmentService {

    private final com.ksprogramming.tnb.repository.EquipmentRepository equipmentRepository;
    EquipmentMapper equipmentMapper;

    public EquipmentService(com.ksprogramming.tnb.repository.EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public EquipmentData createEquipment(EquipmentData equipmentData) {


        Equipment equipment = equipmentMapper.toEntity(equipmentData);

        Equipment savedEquipment = equipmentRepository.save(equipment);

        return equipmentMapper.toData(savedEquipment);
    }

    public EquipmentData updateEquipment(EquipmentData equipmentData) {
        equipmentData.setUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        Equipment equipment = equipmentMapper.toEntity(equipmentData);

        Equipment savedEquipment = equipmentRepository.save(equipment);

        return equipmentMapper.toData(savedEquipment);
    }

    public List<EquipmentData> findAllEquipment() {
        List<EquipmentData> equipmentDataList = new ArrayList<>();

        equipmentRepository.findAll().forEach(equipment -> {

            equipmentDataList.add(equipmentMapper.toData(equipment));
        });
        return equipmentDataList;
    }

    public EquipmentData getEquipmentById(Long id) {
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        if (equipment.isPresent()) {
            return equipmentMapper.toData(equipment.get());
        }
        throw new RuntimeException("Equipment not found with id: " + id);
    }
    public void deleteEquipment(Long id) {
        Optional<Equipment> equipmentOptional = equipmentRepository.findById(id);
        if (equipmentOptional.isPresent()) {

            EquipmentData equipmentData = equipmentMapper.toData(equipmentOptional.get());
            equipmentData.setDeleteDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

            equipmentRepository.save(equipmentMapper.toEntity(equipmentData));
        } else {
            throw new RuntimeException("Equipment not found with id: " + id);
        }
    }

}
