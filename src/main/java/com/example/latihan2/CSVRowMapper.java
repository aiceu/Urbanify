package com.example.latihan2;

@FunctionalInterface
public interface CSVRowMapper<T> {
    T mapRow(String[] row);
}
