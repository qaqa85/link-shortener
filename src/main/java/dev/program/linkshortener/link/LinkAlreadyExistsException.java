package dev.program.linkshortener.link;

class LinkAlreadyExistsException extends RuntimeException {

    LinkAlreadyExistsException() {
        super("This link already exists!");
    }
}
