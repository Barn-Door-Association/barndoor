package com.codeup.barndoor.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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
    private long tagId;

    @Column(nullable = false, unique = true)
    private String name;

    //Date Format YYYY-MM-DD
    @Column(nullable = false, columnDefinition = "date")
    private Date dob;

    @Column(nullable = false)
    private char sex;

    @Column(nullable = false)
    private String breed;

    //Weight in pounds
    @Column(nullable = false)
    private long weightInPounds;

    // Adds relationship to Herd table using "herd_id" as foreign key
    @ManyToOne
    @JoinColumn(name = "herd_id") //assigns foreign key
    @JsonIgnore
    private Herd herd;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goat")
    @JsonIgnore
    private List<VaccineRecord> records;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedigree", joinColumns = {
            @JoinColumn(name = "goat_id")
    }, inverseJoinColumns = {@JoinColumn(name = "parent_id")})
    private Set<Goat> parents;

    @ManyToMany(mappedBy = "parents")
    @JsonIgnore
    private Set<Goat> children;

    public Goat() {
    }

    public Goat(long tagId, String name, Date dob, char sex, String breed, long weightInPounds, Herd herd) {
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

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
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

    public long getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(long weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public Herd getHerd() {
        return herd;
    }

    public void setHerd(Herd herd) {
        this.herd = herd;
    }

    public List<VaccineRecord> getRecords() {
        return records;
    }

    public void setRecords(List<VaccineRecord> records) {
        this.records = records;
    }

    public Set<Goat> getParents() {
        return parents;
    }

    public void setParents(Set<Goat> parents) {
        this.parents = parents;
    }

    public Set<Goat> getChildren() {
        return children;
    }

    public void setChildren(Set<Goat> children) {
        this.children = children;
    }
}
