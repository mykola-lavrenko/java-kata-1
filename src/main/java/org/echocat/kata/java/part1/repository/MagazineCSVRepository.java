package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.domain.Magazine;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MagazineCSVRepository implements MagazineRepository {
    private static final String MAGAZINES_CSV_FILE_PATH = "org/echocat/kata/java/part1/data/magazines.csv";
    private final CSVReader<Magazine> csvReader;

    public MagazineCSVRepository(CSVReader<Magazine> csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public List<Magazine> findAll() {
        return csvReader.readFile(MAGAZINES_CSV_FILE_PATH, Magazine.class);
    }

    @Override
    public List<Magazine> findAllByAuthor(String email) {
        return findAll().stream().filter(book -> book.getAuthors().contains(email)).collect(Collectors.toList());
    }

    @Override
    public Optional<Magazine> findByIsbn(String isbn) {
        return findAll().stream().filter(book -> isbn.equals(book.getIsbn())).findFirst();
    }


}
