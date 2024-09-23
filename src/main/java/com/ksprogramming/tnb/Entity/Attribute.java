package com.ksprogramming.tnb.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public Attribute() {
    }

    public Attribute(Long id, String name, String type, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) {
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
    public static AttributeBuilder builder(){
        return new AttributeBuilder();
    }

    public static class AttributeBuilder{
        private Long id;
        private String name;
        private String type;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private LocalDateTime deleteDate;

        public AttributeBuilder id(Long id){
            this.id = id;
            return this;
        }
        public AttributeBuilder name(String name){
            this.name = name;
            return this;
        }
        public AttributeBuilder type(String type){
            this.type = type;
            return this;
        }
        public AttributeBuilder createDate(LocalDateTime createDate){
            this.createDate = createDate;
            return this;
        }
        public AttributeBuilder updateDate(LocalDateTime updateDate){
            this.updateDate = updateDate;
            return this;
        }
        public AttributeBuilder deleteDate(LocalDateTime deleteDate){
            this.deleteDate = deleteDate;
            return this;
        }
        public Attribute build(){
            return new Attribute(id, name, type, createDate, updateDate, deleteDate);
        }
    }
}
