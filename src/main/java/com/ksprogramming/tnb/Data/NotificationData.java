package com.ksprogramming.tnb.Data;

import java.time.LocalDateTime;

public class NotificationData {

    private Long id;
    private String title;
    private String message;
    private boolean readStatus;
    private LocalDateTime sentDate;
    private LocalDateTime readDate;
    private Long userId;

    public NotificationData() {
    }

    public NotificationData(Long id, String title, String message, boolean readStatus, LocalDateTime sentDate, LocalDateTime readDate, Long userId) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.readStatus = readStatus;
        this.sentDate = sentDate;
        this.readDate = readDate;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
