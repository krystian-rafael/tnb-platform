package com.ksprogramming.tnb.Data;

import java.time.LocalDateTime;

public class EquipmentData {
    private Long id;
    private String name;
    private String type;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public EquipmentData(Long id, String name, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate, Long aLong) {
    }

    public EquipmentData(Long id, String name, String type, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteDate = deleteDate;
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

    public static EquipmentDataBuilder builder(){
        return new EquipmentDataBuilder();
    }

    public static class EquipmentDataBuilder {
        private Long id;
        private String name;
        private String type;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private LocalDateTime deleteDate;

        public EquipmentDataBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public EquipmentDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EquipmentDataBuilder type(String type) {
            this.type = type;
            return this;
        }

        public EquipmentDataBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public EquipmentDataBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public EquipmentDataBuilder deleteDate(LocalDateTime deleteDate) {
            this.deleteDate = deleteDate;
            return this;
        }

        public EquipmentData build() {
            return new EquipmentData(id, name, type, createDate, updateDate, deleteDate);
        }
    }
}
