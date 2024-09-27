package com.ksprogramming.tnb.Mapper;

import com.ksprogramming.tnb.Data.AttributeData;
import com.ksprogramming.tnb.Data.UserData;
import com.ksprogramming.tnb.Entity.Attribute;
import com.ksprogramming.tnb.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserData entityToData(User user) {
        return UserData.builder().id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .emailConfirmedRegistrator(user.getEmailConfirmedRegistrator())
                .language(user.getLanguage())
                .createDate(user.getCreateDate())
                .editDate(user.getEditDate())
                .deleteDate(user.getDeleteDate())
                .build();
    }

    public static User dataToEntity(UserData userData) {
        return User.builder().id(userData.getId())
                .login(userData.getLogin())
                .password(userData.getPassword())
                .emailConfirmedRegistrator(userData.getEmailConfirmedRegistrator())
                .language(userData.getLanguage())
                .createDate(userData.getCreateDate())
                .editDate(userData.getEditDate())
                .deleteDate(userData.getDeleteDate())
                .build();
    }

    public static List<UserData> enitiesToDataList(List<User> users){
        List<UserData> dataList = new ArrayList<>();
        users.forEach(user -> dataList.add(entityToData(user)));
        return dataList;
    }

    public static List<User> dataListToEnities(List<UserData> userDataList) {
        List<User> users = new ArrayList<>();
        userDataList.forEach(userData -> users.add(dataToEntity(userData)));
        return users;
    }

}
