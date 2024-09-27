package com.ksprogramming.tnb.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private boolean emailConfirmedRegistrator;
    private String language;

    private LocalDateTime createDate;
    private LocalDateTime editDate;
    private LocalDateTime deleteDate;

    public User(String login, String password, boolean emailConfirmedRegistrator) {
    }

    public User(Long id, String login, String password, boolean emailConfirmedRegistrator, String language, LocalDateTime createDate, LocalDateTime editDate, LocalDateTime deleteDate) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.emailConfirmedRegistrator = emailConfirmedRegistrator;
        this.language = language;
        this.createDate = createDate;
        this.editDate = editDate;
        this.deleteDate = deleteDate;
    }

    public User(String login, String password, boolean emailConfirmedRegistrator, String language) {
        this.login = login;
        this.password = password;
        this.emailConfirmedRegistrator = emailConfirmedRegistrator;
        this.language = language;

    }

    public User() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEmailConfirmedRegistrator() {
        return emailConfirmedRegistrator;
    }

    public void setEmailConfirmedRegistrator(boolean emailConfirmedRegistrator) {
        this.emailConfirmedRegistrator = emailConfirmedRegistrator;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static class UserBuilder{
        private Long id;
        private String login;
        private String password;
        private boolean emailConfirmedRegistrator;
        private String language;
        private LocalDateTime createDate;
        private LocalDateTime editDate;
        private LocalDateTime deleteDate;

        public UserBuilder id(Long id){
            this.id = id;
            return this;
        }
        public UserBuilder login(String login){
            this.login = login;
            return this;
        }
        public UserBuilder password(String password){
            this.password = password;
            return this;
        }
        public UserBuilder emailConfirmedRegistrator(boolean emailConfirmedRegistrator){
            this.emailConfirmedRegistrator = emailConfirmedRegistrator;
            return this;
        }

        public UserBuilder language(String language){
            this.language = language;
            return this;
        }
        public UserBuilder createDate(LocalDateTime createDate){
            this.createDate = createDate;
            return this;
        }
        public UserBuilder editDate(LocalDateTime editDate){
            this.editDate = editDate;
            return this;
        }
        public UserBuilder deleteDate(LocalDateTime deleteDate){
            this.deleteDate = deleteDate;
            return this;
        }
        public User build(){
            return new User(id, login, password, emailConfirmedRegistrator, language, createDate, editDate, deleteDate);
        }


    }
}
