package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.UserAuthorityData;
import com.ksprogramming.tnb.Entity.UserAuthority;
import com.ksprogramming.tnb.Exception.NoUserException;
import com.ksprogramming.tnb.Mapper.UserAuthorityMapper;
import com.ksprogramming.tnb.Repository.UserAuthorityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserAuthorityService implements UserAuthorityServiceInterface {
    private final UserAuthorityRepository userAuthorityRepository;

    public UserAuthorityService(UserAuthorityRepository userAuthorityRepository) {
        this.userAuthorityRepository = userAuthorityRepository;
    }

    public UserAuthorityData createUserAuthority(UserAuthorityData userAuthorityData) {
        userAuthorityData.setCreateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return UserAuthorityMapper.entityToData(userAuthorityRepository.save(UserAuthorityMapper.dataToEntity(userAuthorityData)));
    }

    public UserAuthorityData updateUserAuthority(UserAuthorityData userAuthorityData) {
        userAuthorityData.setUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return UserAuthorityMapper.entityToData(userAuthorityRepository.save(UserAuthorityMapper.dataToEntity(userAuthorityData)));
    }

    public void deleteUserAuthority(Long id) {
        UserAuthorityData authority = getAuthorityById(id);
        authority.setDeleteDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        userAuthorityRepository.save(UserAuthorityMapper.dataToEntity(authority));
    }

    public List<UserAuthorityData> findAllAuthorities() {
        return UserAuthorityMapper.entityToDataList(userAuthorityRepository.findAllAuthorities());
    }

    public UserAuthorityData getAuthorityById(Long id) {
        Optional<UserAuthority> userAuthority = userAuthorityRepository.findById(id);
        if (userAuthority.isPresent()) {
            return UserAuthorityMapper.entityToData(userAuthority.get());
        }
        throw new NoUserException("Not find user authority with id:" + id);
    }
}
