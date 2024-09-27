package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.UserData;
import com.ksprogramming.tnb.Enumes.Language;
import com.ksprogramming.tnb.Repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-integrationtest.properties")
class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();  // Ensures a clean slate before each test
    }

    @Test
    void createUser() {
        // GIVEN
        UserData user = UserData.builder()
                .login("JohnDoe")
                .password("password123")
                .emailConfirmedRegistrator(false)
                .language(Language.ENGLISH.name())  // Using Language Enum
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build();

        userService.createUser(user);

        // WHEN
        List<UserData> results = userService.findAllUsers();

        // EXPECTED
        Assert.assertEquals(1, results.size());

        List<String> logins = new ArrayList<>();
        results.forEach(userData -> logins.add(userData.getLogin()));
        Assert.assertTrue(logins.contains("JohnDoe"));

        List<String> languages = new ArrayList<>();
        results.forEach(userData -> languages.add(userData.getLanguage()));
        Assert.assertTrue(languages.contains(Language.ENGLISH.name()));
    }

    @Test
    void updateUser() {
        // GIVEN
        UserData user = userService.createUser(UserData.builder()
                .login("JohnDoe")
                .password("password123")
                .emailConfirmedRegistrator(false)
                .language(Language.ENGLISH.name())
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        // WHEN
        user.setLanguage(Language.SPANISH.name());
        UserData updatedUser = userService.updateUser(user);

        // EXPECTED
        Assert.assertEquals(Language.SPANISH.name(), updatedUser.getLanguage());
        Assert.assertEquals("JohnDoe", updatedUser.getLogin());
    }

    @Test
    void findUserById() {
        // GIVEN
        UserData user = userService.createUser(UserData.builder()
                .login("JaneDoe")
                .password("password321")
                .emailConfirmedRegistrator(true)
                .language(Language.FRENCH.name())
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        // WHEN
        UserData result = userService.findUserById(user.getId());

        // EXPECTED
        Assert.assertEquals(user.getLogin(), result.getLogin());
        Assert.assertEquals(user.getLanguage(), result.getLanguage());
        Assert.assertEquals(user.getCreateDate(), result.getCreateDate());
    }

    @Test
    void findAllUsers() {
        // GIVEN
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        UserData userDataFirst = new UserData("JohnDoe", "password123", Language.ENGLISH.name(), now);
        userService.createUser(userDataFirst);
        UserData userDataSecond = new UserData("JaneDoe", "password321", Language.SPANISH.name(), now);
        userService.createUser(userDataSecond);

        // WHEN
        List<UserData> results = userService.findAllUsers();

        // EXPECTED
        Assert.assertEquals(2, results.size());

        List<String> logins = new ArrayList<>();
        results.forEach(userData -> logins.add(userData.getLogin()));
        Assert.assertTrue(logins.contains("JohnDoe"));
        Assert.assertTrue(logins.contains("JaneDoe"));

        List<String> languages = new ArrayList<>();
        results.forEach(userData -> languages.add(userData.getLanguage()));
        Assert.assertTrue(languages.contains(Language.ENGLISH.name()));
        Assert.assertTrue(languages.contains(Language.SPANISH.name()));

        List<LocalDateTime> createDates = new ArrayList<>();
        results.forEach(userData -> createDates.add(userData.getCreateDate()));
        Assert.assertTrue(createDates.contains(now));
    }

    @Test
    void deleteUser() {
        // GIVEN
        UserData userFirst = userService.createUser(UserData.builder()
                .login("JohnDoe")
                .password("password123")
                .emailConfirmedRegistrator(false)
                .language(Language.ENGLISH.name())
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        UserData userSecond = userService.createUser(UserData.builder()
                .login("JaneDoe")
                .password("password321")
                .emailConfirmedRegistrator(true)
                .language(Language.SPANISH.name())
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        userService.deleteUser(userSecond.getId());

        // WHEN
        List<UserData> results = userService.findAllUsers();

        // EXPECTED
        Assert.assertEquals(1, results.size());

        List<String> logins = new ArrayList<>();
        results.forEach(userData -> logins.add(userData.getLogin()));
    }
}
