package com.ksprogramming.tnb.Data;

import java.time.LocalDateTime;

public class AttributeData {
    private Long id;
    private String name;
    private String type;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public AttributeData() {
    }

    public AttributeData(Long id, String name, String type, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteDate = deleteDate;
    }

    public AttributeData(String name, String type, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) {
        this.name = name;
        this.type = type;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteDate = deleteDate;
    }

    public AttributeData(String name, String type, LocalDateTime createDate) {
        this.name = name;
        this.type = type;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }
    public static AttributeDataBuilder builder(){
        return new AttributeDataBuilder();
    }

    public static class AttributeDataBuilder{
        private Long id;
        private String name;
        private String type;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private LocalDateTime deleteDate;

        public AttributeDataBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public AttributeDataBuilder name(String name) {
            this.name = name;
            return this;
        }
        public AttributeDataBuilder type(String type) {
            this.type = type;
            return this;
        }
        public AttributeDataBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }
        public AttributeDataBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }
        public AttributeDataBuilder deleteDate(LocalDateTime deleteDate) {
            this.deleteDate = deleteDate;
            return this;
        }
        public AttributeData build() {
            return new AttributeData(id, name, type, createDate, updateDate, deleteDate);
        }
    }
}
