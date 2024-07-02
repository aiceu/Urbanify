package com.example.latihan2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AddAduanController implements Initializable {
    @FXML
    private ImageView addAduanBG;
    @FXML
    private ImageView logoImageView;
    @FXML
    private TextField judulField;
    @FXML
    private ComboBox<String> kategoriComboBox;
    @FXML
    private ComboBox<String> provinsiComboBox;
    @FXML
    private ComboBox<String> kabupatenComboBox;
    @FXML
    private ComboBox<String> kelurahanComboBox;
    @FXML
    private TextField rtRwField;
    @FXML
    private TextArea rincianAduanArea;
    @FXML
    private ImageView uploadFotoImageView;
    @FXML
    private ImageView uploadVideoImageView;
    @FXML
    private Button batalButton;
    @FXML
    private Button simpanButton;


    private void setImage(String imageUrl) {
        Image image = new Image(getClass().getResourceAsStream(imageUrl));
        addAduanBG.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String imageUrl = "/images/UserDashboard.png";
        setImage(imageUrl);

        kategoriComboBox.getItems().addAll("Kategori 1", "Kategori 2", "Kategori 3");
        provinsiComboBox.getItems().addAll("Provinsi 1", "Provinsi 2", "Provinsi 3");
        kabupatenComboBox.getItems().addAll("Kabupaten 1", "Kabupaten 2", "Kabupaten 3");
        kelurahanComboBox.getItems().addAll("Kelurahan 1", "Kelurahan 2", "Kelurahan 3");

        // Set action for the buttons
        batalButton.setOnAction(event -> clearForm());
        simpanButton.setOnAction(event -> saveFormData());
    }

    private void clearForm() {
        judulField.clear();
        kategoriComboBox.getSelectionModel().clearSelection();
        provinsiComboBox.getSelectionModel().clearSelection();
        kabupatenComboBox.getSelectionModel().clearSelection();
        kelurahanComboBox.getSelectionModel().clearSelection();
        rtRwField.clear();
        rincianAduanArea.clear();
        // Clear the image views if needed
    }

    private void saveFormData() {
        // Logic to save form data
    }
}
