package com.codeup.barndoor.models;

public class UserRequest {

    private long id;
    private String ranchName;
    private String firstName;
    private String lastName;
    private String email;

    public UserRequest() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRanchName() {
        return ranchName;
    }

    public void setRanchName(String ranchName) {
        this.ranchName = ranchName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
