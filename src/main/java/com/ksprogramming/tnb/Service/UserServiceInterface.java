package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.UserData;
import com.ksprogramming.tnb.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    public UserData createUser(UserData userData);
    public Optional<UserData> getUserById(Long id);
    public UserData updateUser(Long id, UserData updatedData);
    public void deleteUser(Long id);
    public List<UserData> getAllUsers();



}
