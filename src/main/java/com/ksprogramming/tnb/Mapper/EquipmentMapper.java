package com.ksprogramming.tnb.Mapper;

import com.ksprogramming.tnb.Data.EquipmentData;
import com.ksprogramming.tnb.Entity.Equipment;
import org.springframework.stereotype.Component;

@Component
public class EquipmentMapper {

    // Converts Equipment entity to EquipmentData DTO
    public EquipmentData toData(Equipment equipment) {
        return new EquipmentData(
                equipment.getId(),
                equipment.getName(),
                equipment.getCreateDate(),
                equipment.getUpdateDate(),
                equipment.getDeleteDate(),
                equipment.getUser() != null ? equipment.getUser().getId() : null
        );
    }


    public Equipment toEntity(EquipmentData equipmentData) {
        Equipment equipment = new Equipment();
        equipment.setId(equipmentData.getId());
        equipment.setName(equipmentData.getName());
        equipment.setCreateDate(equipmentData.getCreateDate());
        equipment.setUpdateDate(equipmentData.getUpdateDate());
        equipment.setDeleteDate(equipmentData.getDeleteDate());
        // Note: User mapping logic should be handled separately if needed
        return equipment;
    }
}
