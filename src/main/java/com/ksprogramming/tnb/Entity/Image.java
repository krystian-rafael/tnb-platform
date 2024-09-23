package com.ksprogramming.tnb.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public Image() {
    }

    public Image(Long id, String path, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) {
        this.id = id;
        this.path = path;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteDate = deleteDate;
    }

    public Image(String path, LocalDateTime createDate) {
        this.path = path;
        this.createDate = createDate;
    }

    public Image(Long id, String path, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.path = path;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public static ImageBuilder builder(){
        return new ImageBuilder();
    }
    public static class ImageBuilder{
        private Long id;
        private String path;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private LocalDateTime deleteDate;
        public ImageBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public ImageBuilder path(String path) {
            this.path = path;
            return this;
        }
        public ImageBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }
        public ImageBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }
        public ImageBuilder deleteDate(LocalDateTime deleteDate) {
            this.deleteDate = deleteDate;
            return this;
        }
        public Image build(){
            return new Image(id, path, createDate, updateDate, deleteDate);
        }
    }
}
