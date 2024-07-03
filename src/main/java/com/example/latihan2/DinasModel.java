package com.example.latihan2;

public class DinasModel {
    private String namaDinas;
    private String alamatDinas;
    private String kategoriDinas;
    private String emailDinas;
    private String websiteDinas;

    public DinasModel(String namaDinas, String alamatDinas, String kategoriDinas, String emailDinas, String websiteDinas) {
        this.namaDinas = namaDinas;
        this.alamatDinas = alamatDinas;
        this.kategoriDinas = kategoriDinas;
        this.emailDinas = emailDinas;
        this.websiteDinas = websiteDinas;
    }
    public DinasModel() {
    }

    public String getNamaDinas() {
        return namaDinas;
    }

    public void setNamaDinas(String namaDinas) {
        this.namaDinas = namaDinas;
    }

    public String getAlamatDinas() {
        return alamatDinas;
    }

    public void setAlamatDinas(String alamatDinas) {
        this.alamatDinas = alamatDinas;
    }

    public String getKategoriDinas() {
        return kategoriDinas;
    }

    public void setKategoriDinas(String kategoriDinas) {
        this.kategoriDinas = kategoriDinas;
    }

    public String getEmailDinas() {
        return emailDinas;
    }

    public void setEmailDinas(String emailDinas) {
        this.emailDinas = emailDinas;
    }

    public String getWebsiteDinas() {
        return websiteDinas;
    }

    public void setWebsiteDinas(String websiteDinas) {
        this.websiteDinas = websiteDinas;
    }
    public static final CSVRowMapper<DinasModel> MAPPER = new CSVRowMapper<>() {
        @Override
        public DinasModel mapRow(String[] row) {
            return new DinasModel(row[0], row[1], row[2], row[3], row[4]);
        }

        @Override
        public String[] mapRowBack(DinasModel item) {
            return new String[]{
                    item.getNamaDinas(),
                    item.getAlamatDinas(),
                    item.getKategoriDinas(),
                    item.getEmailDinas(),
                    item.getWebsiteDinas()
            };
        }
    };
}
