package com.ksprogramming.tnb.Data;

import java.time.LocalDateTime;

public class ImageData {
    private Long id;
    private String path;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public ImageData() {
    }

    public ImageData(Long id, String path, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) {
        this.id = id;
        this.path = path;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteDate = deleteDate;
    }

    public ImageData(Long id, String path, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.path = path;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public ImageData(String path, LocalDateTime createDate) {
        this.path = path;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }

    public static ImageDataBuilder builder(){
        return new ImageDataBuilder();
    }
    public static class ImageDataBuilder {
        private Long id;
        private String path;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private LocalDateTime deleteDate;
        public ImageDataBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public ImageDataBuilder path(String path) {
            this.path = path;
            return this;
        }
        public ImageDataBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }
        public ImageDataBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }
        public ImageDataBuilder deleteDate(LocalDateTime deleteDate) {
            this.deleteDate = deleteDate;
            return this;
        }
        public ImageData build() {
            return new ImageData(id, path, createDate, updateDate, deleteDate);
        }
    }
}
