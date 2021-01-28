package org.echocat.kata.java.part1.domain;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDate;
import java.util.List;

public class Magazine extends Publication {
    @CsvDate("dd.MM.yyyy")
    @CsvBindByName
    private LocalDate publishedAt;


    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }
}
