package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.AttributeData;
import com.ksprogramming.tnb.Exception.NoAttributeWithThatId;
import com.ksprogramming.tnb.Mapper.AttributeMapper;
import com.ksprogramming.tnb.Repository.AttributeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeService implements AttributeServiceInterface{
    private AttributeRepository attributeRepository;

    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    public AttributeData createAttribute(AttributeData attributeData) {
        return AttributeMapper.entityToData(attributeRepository.save(AttributeMapper.dataToEntity(attributeData)));
    }

    public AttributeData updateAttribute(AttributeData attributeData) {
        return AttributeMapper.entityToData(attributeRepository.save(AttributeMapper.dataToEntity(attributeData)));
    }

    public AttributeData findAttributeById(Long id) {
        return AttributeMapper.entityToData(attributeRepository.findById(id).orElseThrow(() -> new NoAttributeWithThatId("No attribute found with id:" + id)));
    }

    public List<AttributeData> findAllAttributes() {
        List<AttributeData> attributes = new ArrayList<>();
        attributeRepository.findAllNotDeleted().forEach(attribute -> {
            attributes.add(AttributeMapper.entityToData(attribute));
        });
        return attributes;
    }
    public void deleteAttributeById(Long id) {
        AttributeData attributeData = AttributeMapper.entityToData(attributeRepository.findById(id).orElseThrow(() -> new NoAttributeWithThatId("No attribute found with id:" + id)));
        attributeData.setDeleteDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        attributeRepository.save(AttributeMapper.dataToEntity(attributeData));
    }
}
