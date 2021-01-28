package org.echocat.kata.java.part1.controller;

import org.echocat.kata.java.part1.dto.PublicationDTO;
import org.echocat.kata.java.part1.services.PublicationService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationController {

    private final PublicationService publicationService;

    public PublicationController(@NonNull PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @RequestMapping("/")
    public List<PublicationDTO> finalAllPublications() {
        return publicationService.finalAllPublications();
    }

    @RequestMapping("/{isbn}")
    public PublicationDTO findPublicationByItsIsbn(@PathVariable("isbn") @NonNull String isbn) {
        return publicationService.findPublicationByIsbn(isbn);
    }

    @RequestMapping("/sorted")
    public List<PublicationDTO> findAllPublicationsSortedByTitle() {
        return publicationService.findAllPublicationsSortedByTitle();
    }

    @RequestMapping("/author/{email}/")
    public List<PublicationDTO> findAllPublicationsOfAuthor(@PathVariable("email") @NonNull String authorEmailAddress) {
        return publicationService.findByAuthor(authorEmailAddress);
    }

}
