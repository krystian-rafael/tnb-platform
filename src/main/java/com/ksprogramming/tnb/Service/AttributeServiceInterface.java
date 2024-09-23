package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.AttributeData;
import com.ksprogramming.tnb.Repository.AttributeRepository;

import java.util.List;

public interface AttributeServiceInterface {
    AttributeData createAttribute(AttributeData attributeData);
    AttributeData updateAttribute(AttributeData attributeData);
    AttributeData findAttributeById(Long id);
    List<AttributeData> findAllAttributes();
    void deleteAttributeById(Long id);
}
