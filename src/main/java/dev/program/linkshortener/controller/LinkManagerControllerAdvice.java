package dev.program.linkshortener.controller;

import dev.program.linkshortener.link.api.exception.LinkAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
class LinkManagerControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(LinkAlreadyExistsException.class)
    ExceptionResponse handleBusinessException(LinkAlreadyExistsException e, WebRequest webRequest) {
        return new ExceptionResponse(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler
    ExceptionResponse handleGlobalErrors(Exception e) {
        return new ExceptionResponse("ERROR - something went wrong");
    }
}
