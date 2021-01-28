package org.echocat.kata.java.part1.services;

import org.echocat.kata.java.part1.domain.Book;
import org.echocat.kata.java.part1.domain.Magazine;
import org.echocat.kata.java.part1.domain.Publication;
import org.echocat.kata.java.part1.dto.PublicationDTO;
import org.echocat.kata.java.part1.exception.PublicationNotFoundException;
import org.echocat.kata.java.part1.repository.BookRepository;
import org.echocat.kata.java.part1.repository.MagazineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

@Service
public class PublicationService {
    private final BookRepository bookRepository;
    private final MagazineRepository magazineRepository;

    public PublicationService(BookRepository bookRepository, MagazineRepository magazineRepository) {
        this.bookRepository = bookRepository;
        this.magazineRepository = magazineRepository;
    }


    public List<PublicationDTO> finalAllPublications() {
        Stream<Book> allBooksByAuthor = bookRepository.findAll().stream();
        Stream<Magazine> allMagazinesByAuthor = magazineRepository.findAll().stream();
        return Stream.concat(allBooksByAuthor, allMagazinesByAuthor).map(this::toDTO).collect(Collectors.toList());
    }

    public List<PublicationDTO> findAllPublicationsSortedByTitle() {
        return finalAllPublications().stream()
                .sorted(comparing(PublicationDTO::getTitle))
                .collect(Collectors.toList());
    }

    public PublicationDTO findPublicationByIsbn(String isbn) {
        Optional<? extends Publication> publication;
        Optional<Book> book = bookRepository.findByIsbn(isbn);
        if (book.isPresent()) {
            publication = book;
        } else {
            publication = magazineRepository.findByIsbn(isbn);
        }

        return toDTO(publication.orElseThrow(PublicationNotFoundException::new));
    }

    public List<PublicationDTO> findByAuthor(String authorEmailAddress) {
        Stream<Book> allBooksByAuthor = bookRepository.findAllByAuthor(authorEmailAddress).stream();
        Stream<Magazine> allMagazinesByAuthor = magazineRepository.findAllByAuthor(authorEmailAddress).stream();
        return Stream.concat(allBooksByAuthor, allMagazinesByAuthor).map(this::toDTO).collect(Collectors.toList());
    }


    private PublicationDTO toDTO(Publication publication) {
        PublicationDTO dto = new PublicationDTO();
        BeanUtils.copyProperties(publication, dto);
        return dto;
    }
}
