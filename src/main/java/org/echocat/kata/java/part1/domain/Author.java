package org.echocat.kata.java.part1.domain;

import com.opencsv.bean.CsvBindByName;


public class Author {
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String firstName;
    @CsvBindByName
    private String lastName;

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
