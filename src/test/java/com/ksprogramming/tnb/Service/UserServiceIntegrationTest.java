package com.ksprogramming.tnb.Service;
import com.ksprogramming.tnb.Data.UserData;
import com.ksprogramming.tnb.Entity.User;
import com.ksprogramming.tnb.Repository.UserRepository;
import com.ksprogramming.tnb.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional 
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll(); 
    }

    @Test
    public void testCreateUser() {
        UserData userData = new UserData("krystian", "password1234", true, "en");
        UserData createdUser = userService.createUser(userData);

        assertThat(createdUser.getId()).isNotNull();
        assertThat(createdUser.getLogin()).isEqualTo("krystian");
        assertThat(createdUser.getPassword()).isEqualTo("password1234");
        assertThat(createdUser.getEmailConfirmedRegistrator()).isTrue();
        assertThat(createdUser.getLanguage()).isEqualTo("en");
        assertThat(createdUser.getEditDate()).isBeforeOrEqualTo(LocalDateTime.now());
    }

    @Test
    public void testGetUserById() {
        UserData userData = new UserData("krystian", "password1234", true, "en");
        UserData createdUser = userService.createUser(userData);

        Optional<UserData> retrievedUser = userService.getUserById(createdUser.getId());

        assertThat(retrievedUser).isPresent();
        assertThat(retrievedUser.get().getLogin()).isEqualTo("krystian");
    }

    @Test
    public void testUpdateUser() {
        UserData userData = new UserData("krystian", "password1234", true, "en");
        UserData createdUser = userService.createUser(userData);

        UserData updatedData = new UserData(createdUser.getId(), "updatedUser", "newPassword", false, "fr", LocalDateTime.now(), null);
        UserData updatedUser = userService.updateUser(createdUser.getId(), updatedData);

        assertThat(updatedUser.getLogin()).isEqualTo("krystianr");
        assertThat(updatedUser.getPassword()).isEqualTo("newPassword12345");
        assertThat(updatedUser.getEmailConfirmedRegistrator()).isFalse();
        assertThat(updatedUser.getLanguage()).isEqualTo("pl");
    }

    @Test
    public void testDeleteUser() {
        UserData userData = new UserData("krystian", "password1234", true, "en");
        UserData createdUser = userService.createUser(userData);

        userService.deleteUser(createdUser.getId());

        Optional<UserData> deletedUser = userService.getUserById(createdUser.getId());
        assertThat(deletedUser).isPresent();
        assertThat(deletedUser.get().getDeleteDate()).isNotNull(); 
    }

    @Test
    public void testGetAllUsers() {
        UserData user1 = new UserData("krystian", "password1234", true, "en");
        UserData user2 = new UserData("rafael", "password2345", false, "pl");
        userService.createUser(user1);
        userService.createUser(user2);

        List<UserData> users = userService.getAllUsers();

        assertThat(users).hasSize(2);
    }
}
