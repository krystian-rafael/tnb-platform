package com.ksprogramming.tnb.Data;

import java.time.LocalDateTime;

public class AssignedAttributeData {
    private Long id;
    private EquipmentData equipment;
    private AttributeData attribute;
    private String value;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public AssignedAttributeData() {
    }

    public AssignedAttributeData(Long id, EquipmentData equipment, AttributeData attribute,
                                 String value, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) {
        this.id = id;
        this.equipment = equipment;
        this.attribute = attribute;
        this.value = value;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteDate = deleteDate;
    }

    public Long getId() {
        return id;
    }

    public EquipmentData getEquipment() {
        return equipment;
    }

    public AttributeData getAttribute() {
        return attribute;
    }

    public String getValue() {
        return value;
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

    public void setEquipment(EquipmentData equipment) {
        this.equipment = equipment;
    }

    public void setAttribute(AttributeData attribute) {
        this.attribute = attribute;
    }

    public void setValue(String value) {
        this.value = value;
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

    public static AssignedAttributeDataBuilder builder(){
        return new AssignedAttributeDataBuilder();
    }

    public static class AssignedAttributeDataBuilder {
        private Long id;
        private EquipmentData equipment;
        private AttributeData attribute;
        private String value;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private LocalDateTime deleteDate;

        public AssignedAttributeDataBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AssignedAttributeDataBuilder equipment(EquipmentData equipment) {
            this.equipment = equipment;
            return this;
        }

        public AssignedAttributeDataBuilder attribute(AttributeData attribute) {
            this.attribute = attribute;
            return this;
        }

        public AssignedAttributeDataBuilder value(String value) {
            this.value = value;
            return this;
        }

        public AssignedAttributeDataBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public AssignedAttributeDataBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public AssignedAttributeDataBuilder deleteDate(LocalDateTime deleteDate) {
            this.deleteDate = deleteDate;
            return this;
        }

        public AssignedAttributeData build() {
            return new AssignedAttributeData(id, equipment, attribute, value, createDate, updateDate, deleteDate);
        }
    }
}
