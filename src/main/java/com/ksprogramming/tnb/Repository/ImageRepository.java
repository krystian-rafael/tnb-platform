package com.ksprogramming.tnb.Repository;

import com.ksprogramming.tnb.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("from Image as i where i.deleteDate is null")
    List<Image> findAllImageNotDeleted();
}
