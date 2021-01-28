package org.echocat.kata.java.part1.controller.handler;

import org.echocat.kata.java.part1.exception.PublicationNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

@ControllerAdvice
public class ServiceExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({PublicationNotFoundException.class})
    public void handle(IllegalArgumentException e) {
        logger.error("Publication wasn't found", e);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ValidationException.class, IllegalArgumentException.class})
    public void handleBadRequest(Exception e) {
        logger.error("Not valid publication", e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public void handle(Exception e) {
        logger.error("Application failed", e);
    }
}
