package dev.program.linkshortener.link.api.exception;

public class LinkAlreadyExistsException extends RuntimeException {

    public LinkAlreadyExistsException() {
        super("This link already exists!");
    }
}
