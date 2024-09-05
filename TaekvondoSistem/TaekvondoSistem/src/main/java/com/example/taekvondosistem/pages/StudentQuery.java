package com.example.taekvondosistem.pages;

import com.example.taekvondosistem.MainForm;
import com.example.taekvondosistem.entities.User;
import com.example.taekvondosistem.services.QueryStudents;
import com.example.taekvondosistem.services.Redirecter;
import com.example.taekvondosistem.services.UserParser;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentQuery extends Application {
    private ListView<String> studentListView;
    private ObservableList<String> studentsList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        Label nameLabel = new Label("Student Name:");
        GridPane.setConstraints(nameLabel, 0, 0);


        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 0);


        Label typeLabel = new Label("Type:");
        GridPane.setConstraints(typeLabel, 0, 1);


        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("All", "Coach", "Parent", "Student");
        typeComboBox.getSelectionModel().selectFirst();
        GridPane.setConstraints(typeComboBox, 1, 1);


        Button queryButton = new Button("Query Students");
        GridPane.setConstraints(queryButton, 1, 2);


        ListView<String> listView = new ListView<>(studentsList);
        GridPane.setConstraints(listView, 1, 3);


        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 2);


        queryButton.setOnAction(e -> {
            String name = nameInput.getText();
            int selectedTypeIndex = typeComboBox.getSelectionModel().getSelectedIndex();
            queryStudents(name, selectedTypeIndex);
        });


        backButton.setOnAction(e -> redirectToMainForm(primaryStage));


        grid.getChildren().addAll(nameLabel, nameInput, typeLabel, typeComboBox, queryButton, listView, backButton);


        Scene scene = new Scene(grid, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Query Students");
        primaryStage.show();
    }

    private void queryStudents(String name, int selectedTypeIndex) {
        studentsList.clear();

        try{
            ObservableList<User> list = QueryStudents.queryStudents(name, selectedTypeIndex);
            for (User u : list) {
                studentsList.add(UserParser.getUserInfo(u));
            }
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
