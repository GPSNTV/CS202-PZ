package com.example.taekvondosistem.entities;

public class Student extends User {
    public Student(String username) {
        super(username, 0);
    }

    @Override
    public String toString() {
        return "Student: " + getUsername();
    }
}
