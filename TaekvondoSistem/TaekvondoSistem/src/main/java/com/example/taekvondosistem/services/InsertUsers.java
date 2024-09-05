package com.example.taekvondosistem.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertUsers {
    public static boolean insertUser(String username, String password, int type) {
        String url = "jdbc:mysql://localhost:3306/cs202-pz";
        String dbUsername = "root";
        String dbPassword = "";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

            connection.setAutoCommit(false);


            String userQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement userStatement = connection.prepareStatement(userQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            userStatement.setString(1, username);
            userStatement.setString(2, password);
            userStatement.executeUpdate();


            int userId = 0;
            try (var rs = userStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    userId = rs.getInt(1);
                }
            }

            if (userId > 0) {

                String roleQuery = "INSERT INTO role (id, type) VALUES (?, ?)";
                PreparedStatement roleStatement = connection.prepareStatement(roleQuery);
                roleStatement.setInt(1, userId);
                roleStatement.setInt(2, type);
                roleStatement.executeUpdate();


                connection.commit();
                System.out.println("User and role inserted successfully!");
                return true;
            } else {

                connection.rollback();
                System.out.println("Failed to insert user.");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }

            return false;
        } finally {
            try {

                connection.setAutoCommit(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
