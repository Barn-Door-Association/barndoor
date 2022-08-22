package com.codeup.barndoor.models;

import java.util.Date;

public class EditGoatRequest {
    private String name;
    private long tagId;
    private String breed;
    private char sex;
    private Date dob;
    private long weightInPounds;
    private long herdId;
    private long goatId;


    public EditGoatRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public long getGoatId() {
        return goatId;
    }

    public void setGoatId(long goatId) {
        this.goatId = goatId;
    }
}
