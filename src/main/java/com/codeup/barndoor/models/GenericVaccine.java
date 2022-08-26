package com.codeup.barndoor.models;

import javax.persistence.*;

@Entity
@Table(name="vaccines")
public class GenericVaccine {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String vaccineName;

    @Column
    private String description;

    public GenericVaccine() {
    }

    public String getName() {
        return vaccineName;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.vaccineName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
