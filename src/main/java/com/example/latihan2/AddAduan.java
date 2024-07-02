package com.example.latihan2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddAduan extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("AddAduan.fxml"));
        Scene addAduanScene = new Scene(fxmlLoader.load(), 1280, 720);
        addAduanScene.getStylesheets().add(getClass().getResource("/CSS/addAduan.css").toExternalForm());
        stage.setTitle("Urbanify - Solusi cepat keluhanmu");
        stage.setScene(addAduanScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
