package org.echocat.kata.java.part1.repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.echocat.kata.java.part1.domain.Book;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.List;

@Component
public class CSVReader<T> {
    public List<T> readFile(String path, Class<T> type) {
        try (Reader reader = Files.newBufferedReader(new ClassPathResource(path).getFile().toPath());) {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withType(type)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
