package com.codeup.barndoor.models;

public class HerdRequest {

    private String herdName;
    private String description;
    private long userId;
    private long herdId;

    public HerdRequest() {
    }

    public HerdRequest(String herdName, String description, long userId) {
        this.herdName = herdName;
        this.description = description;
        this.userId = userId;
    }

    public String getHerdName() {
        return herdName;
    }

    public void setHerdName(String herdName) {
        this.herdName = herdName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getHerdId() {
        return herdId;
    }

    public void setHerdId(long herdId) {
        this.herdId = herdId;
    }

}
