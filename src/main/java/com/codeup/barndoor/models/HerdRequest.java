package com.codeup.barndoor.models;

public class HerdRequest {

    private String herd_name;
    private String description;
    private long userid;

public HerdRequest() {
}
    public String getHerd_name() {
        return herd_name;
    }

    public void setHerd_name(String herd_name) {
        this.herd_name = herd_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
