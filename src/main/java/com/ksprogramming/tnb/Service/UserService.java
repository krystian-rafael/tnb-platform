package com.ksprogramming.tnb.Service;
import com.ksprogramming.tnb.Data.UserData;
import com.ksprogramming.tnb.Entity.User;
import com.ksprogramming.tnb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Convert User to UserData (DTO)
    private UserData convertToUserData(User user) {
        return new UserData(user.getId(), user.getLogin(), user.getPassword(),
                user.getEmailConfirmedRegistrator(), user.getLanguage(),
                user.getEditDate(), user.getDeleteDate());
    }

    // Convert UserData (DTO) to User
    private User convertToUser(UserData userData) {
        return new User(userData.getLogin(), userData.getPassword(),
                userData.getEmailConfirmedRegistrator(), userData.getLanguage());
    }

    // Create a new user
    public UserData createUser(UserData userData) {
        User user = convertToUser(userData);
        user.setEditDate(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        return convertToUserData(savedUser);
    }

    // Get user by ID
    public Optional<UserData> getUserById(Long id) {
        return userRepository.findById(id).map(this::convertToUserData);
    }

    // Update user details
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

    // Soft delete a user
    public void deleteUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setDeleteDate(LocalDateTime.now());
            userRepository.save(user);
        });
    }

    // List all users
    public List<UserData> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToUserData)
                .collect(Collectors.toList());
    }
}