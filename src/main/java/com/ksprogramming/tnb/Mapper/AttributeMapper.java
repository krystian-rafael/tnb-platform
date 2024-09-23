package com.ksprogramming.tnb.Mapper;

import com.ksprogramming.tnb.Data.AttributeData;
import com.ksprogramming.tnb.Entity.Attribute;

import java.util.ArrayList;
import java.util.List;

public class AttributeMapper {
    public static AttributeData entityToData(Attribute attribute) {
        return AttributeData.builder().id(attribute.getId())
                .name(attribute.getName())
                .type(attribute.getType())
                .createDate(attribute.getCreateDate())
                .updateDate(attribute.getUpdateDate())
                .deleteDate(attribute.getDeleteDate())
                .build();
    }
    public static Attribute dataToEntity(AttributeData attributeData) {
        return Attribute.builder().id(attributeData.getId())
                .name(attributeData.getName())
                .type(attributeData.getType())
                .createDate(attributeData.getCreateDate())
                .updateDate(attributeData.getUpdateDate())
                .deleteDate(attributeData.getDeleteDate())
                .build();
    }
    public static List<AttributeData> enitiesToDataList(List<Attribute> attributes) {
        List<AttributeData> dataList = new ArrayList<>();
        attributes.forEach(attribute -> dataList.add(entityToData(attribute)));
        return dataList;
    }
    public static List<Attribute> dataListToEnities(List<AttributeData> attributeDataList) {
        List<Attribute> attributes = new ArrayList<>();
        attributeDataList.forEach(attributeData -> attributes.add(dataToEntity(attributeData)));
        return attributes;
    }
}
