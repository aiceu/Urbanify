package com.example.latihan2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserDashboard extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserDashboard.fxml"));
        Scene UserDashboardScene = new Scene(fxmlLoader.load(), 1280, 720);
        UserDashboardScene.getStylesheets().add(getClass().getResource("/CSS/userDashboard.css").toExternalForm());
        stage.setTitle("Urbanify - Solusi cepat keluhanmu");
        stage.setScene(UserDashboardScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
