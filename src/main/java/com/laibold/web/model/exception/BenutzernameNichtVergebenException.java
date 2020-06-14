package com.laibold.web.model.exception;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ResourceBundle;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BenutzernameNichtVergebenException extends RuntimeException{
    public BenutzernameNichtVergebenException(String username) {
        super(String.format(ResourceBundle.getBundle("messages", LocaleContextHolder.getLocale()).getString("username.notFound"), username));
    }
}
