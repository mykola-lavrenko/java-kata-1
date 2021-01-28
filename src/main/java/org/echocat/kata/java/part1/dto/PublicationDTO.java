package org.echocat.kata.java.part1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

import java.time.LocalDate;
import java.util.List;

public class PublicationDTO {
    private String title;
    private String isbn;
    private List<String> authors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate publishedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
