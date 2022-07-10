package dev.program.linkshortener.link.exception;

public class LinkAlreadyExistsException extends RuntimeException {

    public LinkAlreadyExistsException() {
        super("This link already exists!");
    }
}
