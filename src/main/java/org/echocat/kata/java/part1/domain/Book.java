package org.echocat.kata.java.part1.domain;

import com.opencsv.bean.CsvBindByName;

import java.util.List;

public class Book extends Publication {
    @CsvBindByName
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
