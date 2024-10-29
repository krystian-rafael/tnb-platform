package com.ksprogramming.tnb.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDateTime;

@Entity
public class AssignedAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;
    private String value;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public AssignedAttribute() {
    }

    public AssignedAttribute(Long id, Equipment equipment, Attribute attribute,
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

    public Equipment getEquipment() {
        return equipment;
    }

    public Attribute getAttribute() {
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

    public static AssignedAttributeBuilder builder(){
        return new AssignedAttributeBuilder();
    }

    public static class AssignedAttributeBuilder {
        private Long id;
        private Equipment equipment;
        private Attribute attribute;
        private String value;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private LocalDateTime deleteDate;

        public AssignedAttributeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AssignedAttributeBuilder equipment(Equipment equipment) {
            this.equipment = equipment;
            return this;
        }

        public AssignedAttributeBuilder attribute(Attribute attribute) {
            this.attribute = attribute;
            return this;
        }

        public AssignedAttributeBuilder value(String value) {
            this.value = value;
            return this;
        }

        public AssignedAttributeBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public AssignedAttributeBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public AssignedAttributeBuilder deleteDate(LocalDateTime deleteDate) {
            this.deleteDate = deleteDate;
            return this;
        }

        public AssignedAttribute build() {
            return new AssignedAttribute(id, equipment, attribute, value, createDate, updateDate, deleteDate);
        }
    }
}
