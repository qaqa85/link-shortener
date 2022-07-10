package dev.program.linkshortener.link.exception;

public class LinkAlreadyExistsException extends RuntimeException {

    LinkAlreadyExistsException() {
        super("This link already exists!");
    }
}
