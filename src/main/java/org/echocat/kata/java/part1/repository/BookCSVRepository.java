package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.domain.Book;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookCSVRepository implements BookRepository {
    private static final String BOOKS_CSV_FILE_PATH = "org/echocat/kata/java/part1/data/books.csv";
    private final CSVReader<Book> csvReader;

    public BookCSVRepository(CSVReader<Book> csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public List<Book> findAll() {
        return csvReader.readFile(BOOKS_CSV_FILE_PATH, Book.class);
    }

    @Override
    public List<Book> findAllByAuthor(String email) {
        return findAll().stream()
                .filter(book -> book.getAuthors().contains(email))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return findAll().stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .findFirst();
    }
}
