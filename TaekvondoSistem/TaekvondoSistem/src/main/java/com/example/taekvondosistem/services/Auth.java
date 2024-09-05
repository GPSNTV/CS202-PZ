package com.example.taekvondosistem.services;
import javafx.application.Platform;
import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Auth {
    public static boolean validateLogin(String username, String password) {


        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            out.println("username: " + username);
            out.println("password: " + password);


            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("Server response: " + response);
                if (response.equals("Login successful")) {
                    return true;
                } else {
                    return false;
                }
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean login(String username, String password) {

        if (username.equals("admin") && password.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }
}
