package com.ksprogramming.tnb.Repository;

import com.ksprogramming.tnb.Entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    @Query("FROM Attribute as a where a.deleteDate is null")
    List<Attribute> findAllNotDeleted();
}
