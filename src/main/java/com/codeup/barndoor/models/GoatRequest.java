package com.codeup.barndoor.models;

import java.util.Date;

public class GoatRequest {

    private String name;
    private Date dob;
    private String breed;
    private char sex;
    private long tagId;
    private long weightInPounds;
    private long herdId;

    public GoatRequest() {
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public long getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(long weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public long getHerdId() {
        return herdId;
    }

    public void setHerdId(long herdId) {
        this.herdId = herdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}