package com.example.taekvondosistem.services;

import com.example.taekvondosistem.entities.Coach;
import com.example.taekvondosistem.entities.Parent;
import com.example.taekvondosistem.entities.Student;
import com.example.taekvondosistem.entities.User;

public class UserParser {
    public static String getUserInfo(User u) {
        if (u instanceof Coach) {
            return "Coach: " + u.getUsername();
        } else if (u instanceof Student) {
            return "Student: " + u.getUsername();
        } else if (u instanceof Parent) {
            return "Parent: " + u.getUsername();
        } else {
            throw new IllegalArgumentException("Unknown user type");
        }
    }
}
