package com.ksprogramming.tnb.Mapper;

import com.ksprogramming.tnb.Data.AssignedAttributeData;
import com.ksprogramming.tnb.Entity.AssignedAttribute;

import java.util.ArrayList;
import java.util.List;

public class AssignedAttributeMapper {
    public static AssignedAttributeData entityToData(AssignedAttribute assignedAttribute) {
        return AssignedAttributeData.builder()
                .id(assignedAttribute.getId())
                .equipment(EquipmentMapper.toData(assignedAttribute.getEquipment()))
                .attribute(AttributeMapper.entityToData(assignedAttribute.getAttribute()))
                .value(assignedAttribute.getValue())
                .createDate(assignedAttribute.getCreateDate())
                .updateDate(assignedAttribute.getUpdateDate())
                .deleteDate(assignedAttribute.getDeleteDate())
                .build();
    }

    public static AssignedAttribute dataToEntity(AssignedAttributeData assignedAttributeData) {
        return AssignedAttribute.builder()
                .id(assignedAttributeData.getId())
                .equipment(EquipmentMapper.toEntity(assignedAttributeData.getEquipment()))
                .attribute(AttributeMapper.dataToEntity(assignedAttributeData.getAttribute()))
                .value(assignedAttributeData.getValue())
                .createDate(assignedAttributeData.getCreateDate())
                .updateDate(assignedAttributeData.getUpdateDate())
                .deleteDate(assignedAttributeData.getDeleteDate())
                .build();
    }

    public static List<AssignedAttributeData> entityToDataList(List<AssignedAttribute> assignedAttributes) {
        List<AssignedAttributeData> assignedAttributeDataList = new ArrayList<>();
        assignedAttributes.forEach(assignedAttribute -> {
            assignedAttributeDataList.add(entityToData(assignedAttribute));
        });
        return assignedAttributeDataList;
    }

    public static List<AssignedAttribute> dataToEntityList(List<AssignedAttributeData> assignedAttributeDataList) {
        List<AssignedAttribute> assignedAttributeList = new ArrayList<>();
        assignedAttributeDataList.forEach(assignedAttributeData -> {
            assignedAttributeList.add(dataToEntity(assignedAttributeData));
        });
        return assignedAttributeList;
    }
}
