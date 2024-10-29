package com.ksprogramming.tnb.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "equipment")
    private List<AssignedAttribute> assignedAttributes;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public Equipment() {
    }

    public Equipment(Long id, User user, Image image, List<AssignedAttribute> assignedAttributes, String name, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) {
        this.id = id;
        this.user = user;
        this.image = image;
        this.assignedAttributes = assignedAttributes;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteDate = deleteDate;
    }

    public Equipment(String name, LocalDateTime createDate) {
        this.name = name;
        this.createDate = createDate;
    }

    public Equipment(String name, LocalDateTime createDate, User user, Image image) {
        this.name = name;
        this.createDate = createDate;
        this.user = user;
        this.image = image;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public static EquipmentBuilder builder() {
        return new EquipmentBuilder();
    }

    public List<AssignedAttribute> getAssignedAttributes() {
        return assignedAttributes;
    }

    public void setAssignedAttributes(List<AssignedAttribute> assignedAttributes) {
        this.assignedAttributes = assignedAttributes;
    }

    public static class EquipmentBuilder {
        private Long id;
        private User user;
        private Image image;
        private String name;
        private List<AssignedAttribute> assignedAttributes;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private LocalDateTime deleteDate;

        public EquipmentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public EquipmentBuilder user(User user) {
            this.user = user;
            return this;
        }

        public EquipmentBuilder image(Image image) {
            this.image = image;
            return this;
        }

        public EquipmentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EquipmentBuilder assignedAttributes(List<AssignedAttribute> assignedAttributes) {
            this.assignedAttributes = assignedAttributes;
            return this;
        }

        public EquipmentBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public EquipmentBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public EquipmentBuilder deleteDate(LocalDateTime deleteDate) {
            this.deleteDate = deleteDate;
            return this;
        }

        public Equipment build() {
            return new Equipment(id, user, image, assignedAttributes, name, createDate, updateDate, deleteDate);
        }
    }
}
