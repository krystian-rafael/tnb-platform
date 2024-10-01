package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.UserAuthorityData;
import com.ksprogramming.tnb.Data.UserData;
import com.ksprogramming.tnb.Repository.UserAuthorityRepository;
import com.ksprogramming.tnb.Repository.UserRepository;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-integrationtest.properties")
class UserAuthorityServiceIntegrationTest {

    @Autowired
    private UserAuthorityServiceInterface userAuthorityService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @BeforeEach
    void setUp() {
        userAuthorityRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void createUserAuthority() {

        //GIVEN
        UserData user = userService.createUser(UserData.builder()
                .login("Adam")
                .password("sad")
                .emailConfirmedRegistrator(false)
                .language("Polish")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        UserAuthorityData authority = userAuthorityService.createUserAuthority(UserAuthorityData.builder()
                .user(user)
                .authority("ADMIN")
                .build());
        //WHEN
        List<UserAuthorityData> results = userAuthorityService.findAllAuthorities();
        UserAuthorityData result = userAuthorityService.getAuthorityById(authority.getId());

        //EXPECTED
        assertEquals(1, results.size());
        assertNotNull(result);
        assertEquals(authority.getUser().getId(), result.getUser().getId());
        assertEquals(authority.getAuthority(), result.getAuthority());
        assertEquals(authority.getCreateDate(), result.getCreateDate());
        assertNull(result.getDeleteDate());
    }

    @Test
    void updateUserAuthority() {
        //GIVEN
        UserData user = userService.createUser(UserData.builder()
                .login("Adam")
                .password("sad")
                .emailConfirmedRegistrator(false)
                .language("Polish")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        UserAuthorityData authority = userAuthorityService.createUserAuthority(UserAuthorityData.builder()
                .user(user)
                .authority("ADMIN")
                .build());

        //WHEN
        UserAuthorityData originalResult = userAuthorityService.getAuthorityById(authority.getId());
        originalResult.setAuthority("USER");
        userAuthorityService.updateUserAuthority(originalResult);
        UserAuthorityData updateResult = userAuthorityService.getAuthorityById(authority.getId());

        //EXPECTED
        assertEquals(authority.getUser().getId(), updateResult.getUser().getId());
        assertEquals(authority.getUser().getLogin(), updateResult.getUser().getLogin());
        assertEquals("USER", updateResult.getAuthority());
        assertNull(updateResult.getDeleteDate());

    }

    @Test
    void deleteUserAuthority() {
        //GIVEN
        UserData firstUser = userService.createUser(UserData.builder()
                .login("Adam")
                .password("sad")
                .emailConfirmedRegistrator(false)
                .language("Polish")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        UserAuthorityData firstAuthority = userAuthorityService.createUserAuthority(UserAuthorityData.builder()
                .user(firstUser)
                .authority("ADMIN")
                .build());

        UserAuthorityData secondAuthority = userAuthorityService.createUserAuthority(UserAuthorityData.builder()
                .user(firstUser)
                .authority("USER")
                .build());

        //WHEN
        userAuthorityService.deleteUserAuthority(firstAuthority.getId());
        List<UserAuthorityData> results = userAuthorityService.findAllAuthorities();
        UserAuthorityData result = userAuthorityService.getAuthorityById(firstAuthority.getId());

        //EXPECTED
        assertEquals(1, results.size());
        assertNotNull(result.getDeleteDate());
        List<String> authorities = new ArrayList<>();
        results.stream().forEach(u -> authorities.add(u.getAuthority()));
        assertTrue(authorities.contains("USER"));
        assertFalse(authorities.contains("ADMIN"));
    }

    @Test
    void findAllAuthorities() {
        //GIVEN
        UserData firstUser = userService.createUser(UserData.builder()
                .login("Adam")
                .password("sad")
                .emailConfirmedRegistrator(false)
                .language("Polish")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        UserAuthorityData firstAuthority = userAuthorityService.createUserAuthority(UserAuthorityData.builder()
                .user(firstUser)
                .authority("ADMIN")
                .build());

        UserAuthorityData secondAuthority = userAuthorityService.createUserAuthority(UserAuthorityData.builder()
                .user(firstUser)
                .authority("USER")
                .build());

        //WHEN
        List<UserAuthorityData> results = userAuthorityService.findAllAuthorities();

        //EXPECTED

        List<Long> ids = new ArrayList<>();
        results.stream().forEach(u -> ids.add(u.getId()));
        assertTrue(ids.contains(firstAuthority.getId()));
        assertTrue(ids.contains(secondAuthority.getId()));
        List<String> authorities = new ArrayList<>();
        results.stream().forEach(u -> authorities.add(u.getAuthority()));
        assertTrue(authorities.contains("ADMIN"));
        assertTrue(authorities.contains("USER"));
        List<LocalDateTime> dates = new ArrayList<>();
        results.stream().forEach(u -> dates.add(u.getCreateDate()));
        assertTrue(dates.contains(firstAuthority.getCreateDate()));
        assertTrue(dates.contains(secondAuthority.getCreateDate()));
    }

    @Test
    void getAuthorityById() {
        //GIVEN
        UserData firstUser = userService.createUser(UserData.builder()
                .login("Adam")
                .password("sad")
                .emailConfirmedRegistrator(false)
                .language("Polish")
                .createDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        UserAuthorityData firstAuthority = userAuthorityService.createUserAuthority(UserAuthorityData.builder()
                .user(firstUser)
                .authority("ADMIN")
                .build());

        //WHEN
        UserAuthorityData result = userAuthorityService.getAuthorityById(firstAuthority.getId());

        //EXPECTED
        assertEquals(firstAuthority.getId(), result.getId());
        assertEquals(firstAuthority.getUser().getId(), result.getUser().getId());
        assertEquals(firstAuthority.getAuthority(), result.getAuthority());
        assertEquals(firstAuthority.getCreateDate(), result.getCreateDate());

    }
}