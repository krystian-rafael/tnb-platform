package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.AssignedAttributeData;
import com.ksprogramming.tnb.Exception.NoAttributeWithThatId;
import com.ksprogramming.tnb.Mapper.AssignedAttributeMapper;
import com.ksprogramming.tnb.Repository.AssignedAttributeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
public class AssignedAttributeService implements AssignedAttributeServiceInterface{

    private AssignedAttributeRepository assignedAttributeRepository;

    public AssignedAttributeService(AssignedAttributeRepository assignedAttributeRepository) {
        this.assignedAttributeRepository = assignedAttributeRepository;
    }

    public AssignedAttributeData create(AssignedAttributeData assignedAttributeData) {
        assignedAttributeData.setCreateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return AssignedAttributeMapper.entityToData(assignedAttributeRepository.save(AssignedAttributeMapper.dataToEntity(assignedAttributeData)));
    }

    public AssignedAttributeData get(Long id) {
        return AssignedAttributeMapper.entityToData(assignedAttributeRepository.findById(id).orElseThrow(() -> new NoAttributeWithThatId("No assigned attribute with id " + id)));
    }

    public List<AssignedAttributeData> findAll() {
        return AssignedAttributeMapper.entityToDataList(assignedAttributeRepository.findByDeleteDateIsNull());
    }

    public void update(AssignedAttributeData assignedAttributeData) {
        AssignedAttributeData assignedAttribute  = get(assignedAttributeData.getId());
        assignedAttribute.setValue(assignedAttributeData.getValue());
        assignedAttribute.setUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        assignedAttributeRepository.save(AssignedAttributeMapper.dataToEntity(assignedAttribute));
    }

    public void delete(Long id) {
        AssignedAttributeData assignedAttribute = get(id);
        assignedAttribute.setDeleteDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        assignedAttributeRepository.save(AssignedAttributeMapper.dataToEntity(assignedAttribute));
    }
}
