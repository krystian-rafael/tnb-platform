package com.ksprogramming.tnb.Data;

import java.time.LocalDateTime;

public class UserData {
    private Long id;
    private String login;
    private String password;
    private boolean emailConfirmedRegistrator;
    private String language;
    private LocalDateTime createDate;
    private LocalDateTime editDate;
    private LocalDateTime deleteDate;



    public UserData(Long id, String login, String password, boolean emailConfirmedRegistrator, String language, LocalDateTime createDate, LocalDateTime editDate, LocalDateTime deleteDate) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.emailConfirmedRegistrator = emailConfirmedRegistrator;
        this.language = language;
        this.createDate = createDate;
        this.editDate = editDate;
        this.deleteDate = deleteDate;
    }
    public UserData(String login, String password,String language, LocalDateTime createDate) {
        this.login = login;
        this.password = password;
        this.language = language;
        this.createDate = createDate;
    }
    public UserData() {
        
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserData(String login, String password, boolean emailConfirmedRegistrator, String language) {
        this.login = login;
        this.password = password;
        this.emailConfirmedRegistrator = emailConfirmedRegistrator;
        this.language = language;

    }

    public Long getId() {
        return id;
    }

    public static UserDataBuilder builder(){
        return new UserDataBuilder();
    }
    public static class UserDataBuilder{
        private Long id;
        private String login;
        private String password;
        private boolean emailConfirmedRegistrator;
        private String language;
        private LocalDateTime createDate;
        private LocalDateTime editDate;
        private LocalDateTime deleteDate;

        public UserDataBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public UserDataBuilder login(String login) {
            this.login = login;
            return this;
        }
        public UserDataBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserDataBuilder emailConfirmedRegistrator(boolean emailConfirmedRegistrator) {
            this.emailConfirmedRegistrator = emailConfirmedRegistrator;
            return this;
        }
        public UserDataBuilder language(String language) {
            this.language = language;
            return this;
        }
        public UserDataBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }
        public UserDataBuilder editDate(LocalDateTime editDate) {
            this.editDate = editDate;
            return this;
        }
        public UserDataBuilder deleteDate(LocalDateTime deleteDate) {
            this.deleteDate = deleteDate;
            return this;
        }
        public UserData build() {
            return new UserData(id, login, password, emailConfirmedRegistrator, language, createDate, editDate, deleteDate);
        }


    }

}
