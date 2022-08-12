package com.codeup.barndoor.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "goats")
public class Goat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private int tagId;

    @Column(nullable = false, unique = true)
    private String name;

    //Date Format YYYY-MM-DD
    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false)
    private char sex;

    @Column(nullable = false)
    private String breed;

    //Weight in pounds
    @Column(nullable = false)
    private int weightInPounds;

    // Adds relationship to Herd table using "herd_id" as foreign key
    @ManyToOne
    @JoinColumn (name = "herd_id") //assigns foreign key
    private Herd herd;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goat")
    private List<VaccineRecords> records;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "pedigree", joinColumns = {
            @JoinColumn (name = "goat_id")
     }, inverseJoinColumns = {@JoinColumn (name = "parent_id")
            }
    )
    private Set<Goat> parents;

    public Goat() {
    }

    public Goat(long id, int tagId, String name, Date dob, char sex, String breed, int weightInPounds, Herd herd) {
        this.id = id;
        this.tagId = tagId;
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.breed = breed;
        this.weightInPounds = weightInPounds;
        this.herd = herd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(int weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public Herd getHerd() {
        return herd;
    }

    public void setHerd(Herd herd) {
        this.herd = herd;
    }
}
