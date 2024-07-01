package com.example.latihan2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader<T> {

    private String filePath;
    private CSVRowMapper<T> rowMapper;

    public CSVReader(String filePath, CSVRowMapper<T> rowMapper) {
        this.filePath = filePath;
        this.rowMapper = rowMapper;
    }

    public List<T> readCSV() {
        List<T> itemList = new ArrayList<>();

        try (InputStream is = getClass().getResourceAsStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                T item = rowMapper.mapRow(values);
                itemList.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return itemList;
    }
}
