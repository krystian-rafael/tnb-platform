package com.ksprogramming.tnb.Service;
import com.ksprogramming.tnb.Data.UserData;
import com.ksprogramming.tnb.Entity.User;
import com.ksprogramming.tnb.Exception.NoUserException;
import com.ksprogramming.tnb.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    private UserData convertToUserData(User user) {
        return new UserData(user.getId(), user.getLogin(), user.getPassword(),
                user.getEmailConfirmedRegistrator(), user.getLanguage(),
                user.getEditDate(), user.getDeleteDate());
    }

    private User convertToUser(UserData userData) {
        return new User(userData.getLogin(), userData.getPassword(),
                userData.getEmailConfirmedRegistrator(), userData.getLanguage());
    }

    public UserData createUser(UserData userData) {
        User user = convertToUser(userData);
        user.setEditDate(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        return convertToUserData(savedUser);
    }

    public UserData getUserById(Long id) {
        return userRepository.findById(id).map(this::convertToUserData).orElseThrow(() -> new NoUserException("No user found with id: " + id));
    }

    public UserData updateUser(Long id, UserData updatedData) {
        return userRepository.findById(id).map(user -> {
            user.setLogin(updatedData.getLogin());
            user.setPassword(updatedData.getPassword());
            user.setEmailConfirmedRegistrator(updatedData.getEmailConfirmedRegistrator());
            user.setLanguage(updatedData.getLanguage());
            user.setEditDate(LocalDateTime.now());
            User updatedUser = userRepository.save(user);
            return convertToUserData(updatedUser);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

   @Transactional
    public void deleteUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setDeleteDate(LocalDateTime.now());
            userRepository.save(user);
        });
    }


    public List<UserData> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToUserData)
                .collect(Collectors.toList());
    }
}
