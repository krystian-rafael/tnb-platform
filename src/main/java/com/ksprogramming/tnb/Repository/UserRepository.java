package com.ksprogramming.tnb.Repository;


import com.ksprogramming.tnb.Entity.Attribute;
import com.ksprogramming.tnb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User as a where a.deleteDate is null")
    List<User> findAllNotDeleted();
}
