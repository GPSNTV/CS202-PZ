package com.example.taekvondosistem.entities;

public abstract class User {
    private String username;
    private int type;

    public User(String username, int type) {
        this.username = username;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
}
