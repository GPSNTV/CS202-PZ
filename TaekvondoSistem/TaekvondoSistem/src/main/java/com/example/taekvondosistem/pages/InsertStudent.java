package com.example.taekvondosistem.pages;

import com.example.taekvondosistem.services.InsertUsers;
import com.example.taekvondosistem.services.Redirecter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertStudent extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 1);

        Label typeLabel = new Label("Type:");
        GridPane.setConstraints(typeLabel, 0, 2);

        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("Coach", "Parent", "Student");
        GridPane.setConstraints(typeComboBox, 1, 2);


        Button insertButton = new Button("Insert Student");
        GridPane.setConstraints(insertButton, 1, 3);

        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 3);

        insertButton.setOnAction(e -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            int type = typeComboBox.getSelectionModel().getSelectedIndex();

            if (!username.isEmpty() && !password.isEmpty() && type >= 0) {
                insertStudent(username, password, type);
                usernameInput.clear();
                passwordInput.clear();
                typeComboBox.getSelectionModel().clearSelection();
            }
        });

        backButton.setOnAction(e -> redirectToMainForm(primaryStage));

        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, typeLabel, typeComboBox, insertButton, backButton);

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Insert Student");
        primaryStage.show();
    }

    private void insertStudent(String username, String password, int type) {
        try {
            InsertUsers.insertUser(username, password, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void redirectToMainForm(Stage primaryStage) {
        Redirecter.redirect(new Home(), primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
