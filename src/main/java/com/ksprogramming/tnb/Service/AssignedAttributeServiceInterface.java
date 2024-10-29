package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.AssignedAttributeData;

import java.util.List;

public interface AssignedAttributeServiceInterface {
    AssignedAttributeData create(AssignedAttributeData assignedAttributeData);
    AssignedAttributeData get(Long id);
    List<AssignedAttributeData> findAll();
    void update(AssignedAttributeData assignedAttributeData);
    void delete(Long id);
}
