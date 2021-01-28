package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.domain.Book;
import org.echocat.kata.java.part1.domain.Publication;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository<T extends Publication> {
    List<T> findAll();

    List<T> findAllByAuthor(String email);

    Optional<T> findByIsbn(String isdn);
}
