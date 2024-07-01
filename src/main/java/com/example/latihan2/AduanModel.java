package com.example.latihan2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AduanModel {
    private String profil;
    private String judul;
    private String waktuTempat;
    private String tautanCepat;
    private String status;
    private String detil;

    public AduanModel(String profil, String judul, String waktuTempat, String tautanCepat, String status, String detil) {
        this.profil = profil;
        this.judul = judul;
        this.waktuTempat = waktuTempat;
        this.tautanCepat = tautanCepat;
        this.status = status;
        this.detil = detil;
    }
    public AduanModel() {
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getWaktuTempat() {
        return waktuTempat;
    }

    public void setWaktuTempat(String waktuTempat) {
        this.waktuTempat = waktuTempat;
    }

    public String getTautanCepat() {
        return tautanCepat;
    }

    public void setTautanCepat(String tautanCepat) {
        this.tautanCepat = tautanCepat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetil() {
        return detil;
    }

    public void setDetil(String detil) {
        this.detil = detil;
    }
}
