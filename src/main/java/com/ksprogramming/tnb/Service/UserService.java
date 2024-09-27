package com.ksprogramming.tnb.Service;
import com.ksprogramming.tnb.Data.AttributeData;
import com.ksprogramming.tnb.Data.UserData;
import com.ksprogramming.tnb.Entity.User;
import com.ksprogramming.tnb.Exception.NoAttributeWithThatId;
import com.ksprogramming.tnb.Exception.NoUserException;
import com.ksprogramming.tnb.Mapper.AttributeMapper;
import com.ksprogramming.tnb.Mapper.UserMapper;
import com.ksprogramming.tnb.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // Create a new user
   /* public UserData createUser(UserData userData) {
        User user = convertToUser(userData);
        user.setEditDate(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        return convertToUserData(savedUser);
    }*/
    public UserData createUser(UserData userData) {
        return UserMapper.entityToData(userRepository.save(UserMapper.dataToEntity(userData)));
    }
    public UserData findUserById(Long id) {
        return UserMapper.entityToData(userRepository.findById(id).orElseThrow(() -> new NoUserException("No user found with id:" + id)));
    }


   /* public UserData updateUser(Long id, UserData updatedData) {
        return userRepository.findById(id).map(user -> {
            user.setLogin(updatedData.getLogin());
            user.setPassword(updatedData.getPassword());
            user.setEmailConfirmedRegistrator(updatedData.getEmailConfirmedRegistrator());
            user.setLanguage(updatedData.getLanguage());
            user.setEditDate(LocalDateTime.now());
            User updatedUser = userRepository.save(user);
            return convertToUserData(updatedUser);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }*/
   public UserData updateUser(UserData userData) {
       return UserMapper.entityToData(userRepository.save(UserMapper.dataToEntity(userData)));
   }

   @Transactional
    public void deleteUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setDeleteDate(LocalDateTime.now());
            userRepository.save(user);
        });
    }

    public List<UserData> findAllUsers() {
        List<UserData> users = new ArrayList<>();
        userRepository.findAllNotDeleted().forEach(user -> {
            users.add(UserMapper.entityToData(user));
        });
        return users;
    }
}
