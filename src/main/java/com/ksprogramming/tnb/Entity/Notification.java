package com.ksprogramming.tnb.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private boolean readStatus;
    private LocalDateTime sentDate;
    private LocalDateTime readDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors, Getters, and Setters
    public Notification() {
    }

    public Notification(Long id, String title, String message, boolean readStatus, LocalDateTime sentDate, LocalDateTime readDate, User user) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.readStatus = readStatus;
        this.sentDate = sentDate;
        this.readDate = readDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isReadStatus() {
        return readStatus;
    }

    public void setReadStatus(boolean readStatus) {
        this.readStatus = readStatus;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }

    public LocalDateTime getReadDate() {
        return readDate;
    }

    public void setReadDate(LocalDateTime readDate) {
        this.readDate = readDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
