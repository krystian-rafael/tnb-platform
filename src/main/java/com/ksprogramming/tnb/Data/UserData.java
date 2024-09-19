package com.ksprogramming.tnb.Data;

import java.time.LocalDateTime;

public class UserData {
    private Long id;
    private String login;
    private String password;
    private String emailConfirmedRegistrator;
    private LocalDateTime editDate;
    private LocalDateTime deleteDate;

    public UserData() {
    }

    public UserData(Long id, String login, String password, String emailConfirmedRegistrator, LocalDateTime editDate, LocalDateTime deleteDate) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.emailConfirmedRegistrator = emailConfirmedRegistrator;
        this.editDate = editDate;
        this.deleteDate = deleteDate;
    }

    public Long getId() {
        return id;
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

    public String getEmailConfirmedRegistrator() {
        return emailConfirmedRegistrator;
    }

    public void setEmailConfirmedRegistrator(String emailConfirmedRegistrator) {
        this.emailConfirmedRegistrator = emailConfirmedRegistrator;
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
}
