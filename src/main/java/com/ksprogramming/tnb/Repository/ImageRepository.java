package com.ksprogramming.tnb.Repository;

import com.ksprogramming.tnb.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
