package dev.program.linkshortener.link.api.exception;

public class LinkNotFoundException extends RuntimeException{
    public LinkNotFoundException() {
        super("Link not found exception");
    }
}
