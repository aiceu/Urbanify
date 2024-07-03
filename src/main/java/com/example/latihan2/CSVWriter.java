package com.example.latihan2;

import java.io.*;
import java.util.List;

public class CSVWriter<T> {
    private final String csvFilePath;
    private final CSVRowMapper<T> rowMapper;

    public CSVWriter(String csvFilePath, CSVRowMapper<T> rowMapper) {
        this.csvFilePath = csvFilePath;
        this.rowMapper = rowMapper;
    }

    public void writeCSV(List<T> data) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(csvFilePath))) {
            for (T item : data) {
                String[] values = rowMapper.mapRowBack(item);
                pw.println(String.join(",", values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
