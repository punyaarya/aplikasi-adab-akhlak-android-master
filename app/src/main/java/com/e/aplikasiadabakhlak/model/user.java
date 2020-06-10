package com.e.aplikasiadabakhlak.model;

public class user {
    private int id;
    private String username;
    private String status;

    public user(int id, String username, String status) {
        this.id = id;
        this.username = username;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String password) {
        this.status = status;
    }

}
