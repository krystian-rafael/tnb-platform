package com.ksprogramming.tnb.api;

import java.util.Date;

public class User {
    Long id;
    String login;
    String password;
    String emailConfirmedRegistratior;
    Date edit;
    Date delete;
    public User(Long id, String login) {
        this.id = id;
        this.login = login;
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

    public String getEmailConfirmedRegistratior() {
        return emailConfirmedRegistratior;
    }

    public void setEmailConfirmedRegistratior(String emailConfirmedRegistratior) {
        this.emailConfirmedRegistratior = emailConfirmedRegistratior;
    }

    public Date getEdit() {
        return edit;
    }

    public void setEdit(Date edit) {
        this.edit = edit;
    }

    public Date getDelete() {
        return delete;
    }

    public void setDelete(Date delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", emailConfirmedRegistratior='" + emailConfirmedRegistratior + '\'' +
                ", edit=" + edit +
                ", delete=" + delete +
                '}';
    }
}
