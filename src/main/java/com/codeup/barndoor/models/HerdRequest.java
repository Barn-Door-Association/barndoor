package com.codeup.barndoor.models;

public class HerdRequest {

    private String herd_name;
    private String description;
    private long userid;

    private long herd_id;

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

    public long getHerd_id() {
        return herd_id;
    }

    public void setHerd_id(long herd_id) {
        this.herd_id = herd_id;
    }
}
