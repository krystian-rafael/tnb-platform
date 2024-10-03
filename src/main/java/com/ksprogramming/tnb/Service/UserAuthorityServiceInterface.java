package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.UserAuthorityData;

import java.util.List;

public interface UserAuthorityServiceInterface {
    UserAuthorityData createUserAuthority(UserAuthorityData userAuthorityData);
    UserAuthorityData updateUserAuthority(UserAuthorityData userAuthorityData);
    void deleteUserAuthority(Long id);
    List<UserAuthorityData> findAllAuthorities();
    UserAuthorityData getAuthorityById(Long id);
}
