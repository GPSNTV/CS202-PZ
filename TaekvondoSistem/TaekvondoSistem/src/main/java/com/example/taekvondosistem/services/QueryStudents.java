package com.example.taekvondosistem.services;

import com.example.taekvondosistem.entities.Coach;
import com.example.taekvondosistem.entities.Parent;
import com.example.taekvondosistem.entities.Student;
import com.example.taekvondosistem.entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class QueryStudents {
    public static ObservableList<User> queryStudents(String name, int selectedTypeIndex) {
        ObservableList<User> studentsList = FXCollections.observableArrayList();

        String url = "jdbc:mysql://localhost:3306/cs202-pz";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            logQuery(connection, selectedTypeIndex);
            String query = "SELECT u.username, r.type " +
                    "FROM users u " +
                    "JOIN role r ON u.id = r.id " +
                    "WHERE u.username LIKE ?";

            if (selectedTypeIndex > 0) {
                query += " AND r.type = ?";
            }

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + name + "%");

            if (selectedTypeIndex > 0) {
                preparedStatement.setInt(2, selectedTypeIndex - 1);
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                int type = resultSet.getInt("type");
                if (type == 1) {
                    studentsList.add(new Parent(username));
                } else if (type == 2){
                    studentsList.add(new Student(username));
                } else {
                    studentsList.add(new Coach(username));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    private static void logQuery(Connection connection, int type) {
        try {
            String logQuery = "INSERT INTO log(date, type) VALUES (?, ?)";
            PreparedStatement logStatement = connection.prepareStatement(logQuery);


            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedNow = now.format(formatter);


            logStatement.setString(1, formattedNow);
            logStatement.setInt(2, type);

            logStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
