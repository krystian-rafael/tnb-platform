package com.ksprogramming.tnb.Repository;

import com.ksprogramming.tnb.Entity.AssignedAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssignedAttributeRepository extends JpaRepository<AssignedAttribute, Long> {

    @Query("FROM AssignedAttribute a where a.deleteDate is null")
    List<AssignedAttribute> findByDeleteDateIsNull();
}
