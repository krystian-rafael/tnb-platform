package com.ksprogramming.tnb.Repository;

import com.ksprogramming.tnb.Entity.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {
    @Query("FROM UserAuthority as u where u.deleteDate is null")
    List<UserAuthority> findAllAuthorities();
}
