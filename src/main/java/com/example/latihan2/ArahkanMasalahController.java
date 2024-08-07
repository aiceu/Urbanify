package com.example.latihan2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ArahkanMasalahController implements Initializable {
    @FXML
    private ImageView arahkanMasalahBG;
    @FXML
    private TableView<DinasModel> tableViewDinas;
    @FXML
    private TableColumn<DinasModel, String> namaDinasColumn;
    @FXML
    private TableColumn<DinasModel, String> alamatDinasColumn;
    @FXML
    private TableColumn<DinasModel, String> kategoriDinasColumn;
    @FXML
    private TableColumn<DinasModel, String> emailDinasColumn;
    @FXML
    private TableColumn<DinasModel, String> websiteDinasColumn;
    @FXML
    private Button addDinasButton;
    @FXML
    private Button arahkanMasalahButton;
    @FXML
    private Button searchButton;
    @FXML
    private TextField searchInput;
    private MainApp mainApp;
    private ObservableList<DinasModel> daftarDinas = FXCollections.observableArrayList();
    private AduanModel selectedAduan;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String imageUrl = "/images/ArahkanMasalah.png";
        setImage(imageUrl);

        initializeTableColumns();
        loadCSVData();
        searchButton.setOnAction(event -> filterData());
        searchInput.setOnAction(event -> filterData());
        arahkanMasalahButton.setOnAction(event -> handleArahkanMasalah());
        loadCSVData();
        loadCSVData();loadCSVData();loadCSVData();
    }
    public void initializeTableColumns() {
        namaDinasColumn.setCellValueFactory(new PropertyValueFactory<>("namaDinas"));
        alamatDinasColumn.setCellValueFactory(new PropertyValueFactory<>("alamatDinas"));
        kategoriDinasColumn.setCellValueFactory(new PropertyValueFactory<>("kategoriDinas"));
        emailDinasColumn.setCellValueFactory(new PropertyValueFactory<>("emailDinas"));
        websiteDinasColumn.setCellValueFactory(new PropertyValueFactory<>("websiteDinas"));
    }
    private void setImage(String imageUrl) {
        Image image = new Image(getClass().getResourceAsStream(imageUrl));
        arahkanMasalahBG.setImage(image);
    }

    public void init(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public void setAduanModel(AduanModel aduanModel) {
        this.selectedAduan = aduanModel;
    }
    public void loadCSVData() {
        CSVRowMapper<DinasModel> mapper = values -> new DinasModel(values[0], values[1], values[2], values[3], values[4]);
        CSVReader<DinasModel> csvReader = new CSVReader<>("/CSV/daftarDinas.csv", mapper);
        daftarDinas.setAll(csvReader.readCSV());
        tableViewDinas.setItems(daftarDinas);
    }
    private void filterData() {
        String searchText = searchInput.getText().toLowerCase();
        if (searchText.isEmpty()) {
            tableViewDinas.setItems(daftarDinas);
        } else {
            List<DinasModel> filteredList = daftarDinas.stream()
                    .filter(aduan ->
                            aduan.getNamaDinas().toLowerCase().contains(searchText) ||
                                    aduan.getAlamatDinas().toLowerCase().contains(searchText) ||
                                    aduan.getKategoriDinas().toLowerCase().contains(searchText) ||
                                    aduan.getEmailDinas().toLowerCase().contains(searchText) ||
                                    aduan.getWebsiteDinas().toLowerCase().contains(searchText)
                    )
                    .collect(Collectors.toList());
            tableViewDinas.setItems(FXCollections.observableArrayList(filteredList));
        }
    }
    private void handleArahkanMasalah() {
        DinasModel selectedDinas = tableViewDinas.getSelectionModel().getSelectedItem();
        if (selectedDinas == null) {
            showAlert("No Selection", "Pilih salah satu Dinas untuk diarahkan");
        } else {
            selectedAduan.setStatus("Diarahkan ke " + selectedDinas.getNamaDinas());
            updateAduanStatusInCSV(selectedAduan);
            mainApp.getAdminDashboardController().loadCSVData();
            showAlert("Sukses", "Aduan Berhasil diarahkan");
            mainApp.switchToAdminDashboardScene();
        }
    }
    private void updateAduanStatusInCSV(AduanModel updatedAduan) {
        // Using relative path to the project directory
        String csvFilePath = "src/main/resources/CSV/aduan.csv";

        // Check current working directory
//        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        // Check if the file exists and print the absolute path for debugging
        File file = new File(csvFilePath);
        if (!file.exists()) {
            showAlert("Error", "CSV file not found at: " + file.getAbsolutePath());
            System.out.println("CSV file path: " + file.getAbsolutePath());
            return;
        } else {
//            System.out.println("CSV file path: " + file.getAbsolutePath());
        }

        List<String[]> csvData;

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            csvData = br.lines().map(line -> line.split(",")).collect(Collectors.toList());
        } catch (IOException e) {
            showAlert("Error", "Failed to read CSV file.");
            e.printStackTrace();
            return;
        }

        // Update the relevant row
        for (String[] row : csvData) {
            if (row[0].equals(updatedAduan.getProfil()) && row[1].equals(updatedAduan.getJudul())) {
                row[4] = updatedAduan.getStatus(); // Assuming status is at index 4
                break;
            }
        }

        // Write the updated data back to the CSV
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (String[] row : csvData) {
                pw.println(String.join(",", row));
            }
        } catch (IOException e) {
            showAlert("Error", "Failed to write to CSV file.");
            e.printStackTrace();
        }
        mainApp.getAdminDashboardController().loadCSVData(); // Add this line to reload data in AdminDashboardController
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
