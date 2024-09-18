package com.ksprogramming.tnb;

import java.util.Date;

public class Equipment {
    Long id;
    String name;
    Date dateOfAdd;

    public Equipment(Long id, String name, Date dateOfAdd) {
        this.id = id;
        this.name = name;
        this.dateOfAdd = dateOfAdd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfAdd() {
        return dateOfAdd;
    }

    public void setDateOfAdd(Date dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfAdd=" + dateOfAdd +
                '}';
    }
}
