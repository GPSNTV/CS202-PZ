package com.example.taekvondosistem.entities;

public class Coach extends User {
    public Coach(String username) {
        super(username, 1);
    }

    @Override
    public String toString() {
        return "Coach: " + getUsername();
    }
}
