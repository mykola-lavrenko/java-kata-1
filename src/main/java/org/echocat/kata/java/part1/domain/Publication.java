package org.echocat.kata.java.part1.domain;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

import java.util.List;

public abstract class Publication {
    @CsvBindByName(column = "title")
    private String title;
    @CsvBindByName(column = "isbn")
    private String isbn;
    @CsvBindAndSplitByName(splitOn = ",", elementType = String.class, column = "authors")
    private List<String> authors;


    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
