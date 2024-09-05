package com.example.taekvondosistem.pages;

import com.example.taekvondosistem.services.Redirecter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Home extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button insertStudentButton = new Button("Insert Student");
        Button queryStudentsButton = new Button("Query Students");

        insertStudentButton.setOnAction(e -> redirectToStudentInsertForm(primaryStage));
        queryStudentsButton.setOnAction(e -> redirectToStudentQueryForm(primaryStage));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(insertStudentButton, queryStudentsButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Form");
        primaryStage.show();
    }

    private void redirectToStudentInsertForm(Stage primaryStage) {
        Redirecter.redirect(new InsertStudent(), primaryStage);
    }

    private void redirectToStudentQueryForm(Stage primaryStage) {
        Redirecter.redirect(new StudentQuery(), primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
