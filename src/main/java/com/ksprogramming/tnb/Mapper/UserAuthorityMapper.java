package com.ksprogramming.tnb.Mapper;

import com.ksprogramming.tnb.Data.UserAuthorityData;
import com.ksprogramming.tnb.Entity.UserAuthority;

import java.util.ArrayList;
import java.util.List;

public class UserAuthorityMapper {
    public static UserAuthorityData entityToData(UserAuthority userAuthority) {
        return UserAuthorityData.builder()
                .id(userAuthority.getId())
                .user(UserMapper.entityToData(userAuthority.getUser()))
                .authority(userAuthority.getAuthority())
                .createDate(userAuthority.getCreateDate())
                .updateDate(userAuthority.getUpdateDate())
                .deleteDate(userAuthority.getDeleteDate())
                .build();
    }

    public static UserAuthority dataToEntity(UserAuthorityData userAuthorityData) {
        return UserAuthority.builder()
                .id(userAuthorityData.getId())
                .user(UserMapper.dataToEntity(userAuthorityData.getUser()))
                .authority(userAuthorityData.getAuthority())
                .createDate(userAuthorityData.getCreateDate())
                .updateDate(userAuthorityData.getUpdateDate())
                .deleteDate(userAuthorityData.getDeleteDate())
                .build();
    }

    public static List<UserAuthority> dataToEntityList(List<UserAuthorityData> userAuthorityDataList) {
        List<UserAuthority> authorities = new ArrayList<>();
        userAuthorityDataList.forEach(authority -> {
            authorities.add(UserAuthority.builder()
                    .id(authority.getId())
                    .user(UserMapper.dataToEntity(authority.getUser()))
                    .createDate(authority.getCreateDate())
                    .updateDate(authority.getUpdateDate())
                    .deleteDate(authority.getDeleteDate())
                    .build());
        });
        return authorities;
    }

    public static List<UserAuthorityData> entityToDataList(List<UserAuthority> userAuthorityList) {
        List<UserAuthorityData> authorities = new ArrayList<>();
        userAuthorityList.forEach(authority -> {
            authorities.add(UserAuthorityData.builder()
                    .id(authority.getId())
                    .user(UserMapper.entityToData(authority.getUser()))
                    .authority(authority.getAuthority())
                    .createDate(authority.getCreateDate())
                    .updateDate(authority.getUpdateDate())
                    .deleteDate(authority.getDeleteDate())
                    .build());
        });
        return authorities;
    }
}
