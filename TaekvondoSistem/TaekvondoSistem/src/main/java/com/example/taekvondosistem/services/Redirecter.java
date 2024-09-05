package com.example.taekvondosistem.services;

import com.example.taekvondosistem.pages.Home;
import javafx.application.Application;
import javafx.stage.Stage;

public class Redirecter {
    public static void redirect(Application app, Stage primaryStage) {
        try {
            app.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
