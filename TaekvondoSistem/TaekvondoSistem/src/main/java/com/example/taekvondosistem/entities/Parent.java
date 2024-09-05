package com.example.taekvondosistem.entities;

public class Parent extends User {
    public Parent(String username) {
        super(username, 2);
    }

    @Override
    public String toString() {
        return "Parent: " + getUsername();
    }
}
