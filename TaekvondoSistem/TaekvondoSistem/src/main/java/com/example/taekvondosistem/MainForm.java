package com.example.taekvondosistem;

import com.example.taekvondosistem.pages.Home;
import com.example.taekvondosistem.services.Auth;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainForm extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
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


        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);


        loginButton.setOnAction(e -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            Task<Boolean> loginTask = new Task<Boolean>() {
                @Override
                protected Boolean call() {

                    return Auth.validateLogin(username, password);
                }

                @Override
                protected void succeeded() {
                    if (getValue()) {

                        Platform.runLater(() -> {
                            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + username + "!");
                            redirectToMainForm(primaryStage);
                        });
                    } else {
                        Platform.runLater(() -> {
                            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
                        });
                    }
                }

                @Override
                protected void failed() {
                    Platform.runLater(() -> {

                        showAlert(Alert.AlertType.ERROR, "Login Failed", "An error occurred during login.");
                    });
                }
            };


            new Thread(loginTask).start();
        });


        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton);


        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Form");
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void redirectToMainForm(Stage primaryStage) {
        Home home = new Home();
        try {
            home.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}