package com.example.latihan2;

@FunctionalInterface
public interface CSVRowMapper<T> {
    T mapRow(String[] row);
    default String[] mapRowBack(T item) {
        throw new UnsupportedOperationException("mapRowBack not implemented");
    }
}
